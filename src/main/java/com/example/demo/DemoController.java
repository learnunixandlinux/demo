package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping("/admin")
    public @ResponseBody String greeting(@RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "query", required = false) String query) {

        try {
            Vector<String> columnNames = new Vector<String>();
            Integer numrows = 0;

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(System.getenv("RDS_URL"), System.getenv("RDS_USERNAME"),
                    System.getenv("RDS_PASSWORD"));
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if ("update".equals(type)) {
                numrows = stmt.executeUpdate(query);
            } else if ("select".equals(type)) {
                rs = stmt.executeQuery(query);
                if (rs != null) {
                    ResultSetMetaData columns = rs.getMetaData();
                    int i = 0;
                    while (i < columns.getColumnCount()) {
                        i++;
                        System.out.print(columns.getColumnName(i) + "\t");
                        columnNames.add(columns.getColumnName(i));
                    }
                    System.out.print("\n");

                    while (rs.next()) {
                        for (i = 0; i < columnNames.size(); i++) {
                            System.out.print(rs.getString(columnNames.get(i)) + "\t");

                        }
                        System.out.print("\n");
                    }
                }
            } else {

            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return "greetings";
    }
}
