package ru.cloud.my;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HoneController {

    @Autowired(required = false) DataSource dataSource;
    @Autowired(required = false) ApplicationInstanceInfo instanceInfo;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("instanceInfo", instanceInfo);

        if (instanceInfo != null) {
            Map<Class<?>, String> services = new LinkedHashMap<>();
            services.put(dataSource.getClass(), ((HikariDataSource) dataSource).getJdbcUrl());
            model.addAttribute("services", services.entrySet());
        }

        return "home";
    }
}
