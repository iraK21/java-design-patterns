package org.example.structural.bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

// Bridge pattern is seen when dealing with cross-platform apps such as supporting multiple types of database servers.
@ExtendWith(MockitoExtension.class)
class JavaAPIBridgeTest {

    @Mock
    private Driver mockDerbyDriver;

    @Mock
    private Driver mockMysqlDriver;

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @BeforeAll
    static void initialize() {
        mockStatic(DriverManager.class);
    }

    @BeforeEach
    void setUp() throws SQLException {
        when(DriverManager.getConnection(anyString())).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
    }

    @Test
    void testJdbcDerby() throws SQLException {
        DriverManager.registerDriver(mockDerbyDriver); // Varying implementation
        Connection connection = DriverManager.getConnection("derbyUrl");
        Statement statement = connection.createStatement();
        assertNotNull(statement);
    }

    @Test
    void testJdbcMysql() throws SQLException {
        DriverManager.registerDriver(mockMysqlDriver); // Varying implementation
        Connection connection = DriverManager.getConnection("mysqlUrl");
        Statement statement = connection.createStatement();
        assertNotNull(statement);
    }
}
