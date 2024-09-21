package com.example.lesson9.servlets;

import com.example.lesson9.entity.AuthUser;
import com.example.lesson9.util.ValidationUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "com.example.lesson9.servlets.AuthUserServlet",
        value = "/AuthUser"
)
public class AuthUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String role = req.getParameter("role");
            String about = req.getParameter("about");
            int age = Integer.parseInt(req.getParameter("age"));
//            Locale.setDefault(Locale.forLanguageTag("es"));
            AuthUser authUser = AuthUser.builder()
                    .username(username)
                    .email(email)
                    .role(role)
                    .about(about)
                    .age(age)
                    .build();
//            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//            Validator validator = validatorFactory.getValidator();
//            Set<ConstraintViolation<AuthUser>> constraintViolations = validator.validate(authUser);
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("validation");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Set<String> strings = ValidationUtils.validate(authUser);
            if (strings.size() == 0) {
                entityManager.getTransaction().begin();
                entityManager.persist(authUser);
                entityManager.getTransaction().commit();
            } else {
                for (String errorMessage : strings) {
                    System.out.println(errorMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
