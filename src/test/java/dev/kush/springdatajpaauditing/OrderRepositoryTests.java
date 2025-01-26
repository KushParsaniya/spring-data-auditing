package dev.kush.springdatajpaauditing;

import dev.kush.springdatajpaauditing.config.AuditingConfig;
import dev.kush.springdatajpaauditing.config.SpringSecurityAuditAware;
import dev.kush.springdatajpaauditing.models.Order;
import dev.kush.springdatajpaauditing.repos.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({AuditingConfig.class, SpringSecurityAuditAware.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class OrderRepositoryTests {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Test
    @WithMockUser(
            username = "kush",
            password = "1234",
            roles = "ADMIN"

    )
    public void whenSaveOrderThanCreatedAtAndModifiedAtNotNull() {
        Order order = new Order("abc","COMPLETED",100.0);
        var saved = orderRepository.save(order);
        System.out.println("saved order: " + saved);
        assertThat(saved.getCreatedAt()).isNotNull();
        assertThat(saved.getModifiedAt()).isNotNull();
        assertThat(saved.getCreatedBy().getUsername()).isEqualTo("kush");
        assertThat(saved.getModifiedBy().getUsername()).isEqualTo("kush");
    }
}
