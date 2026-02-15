package com.swissre;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

class JdbcConnectionManagerTest {

    @Test
    void testGetConnectionWithH2Database() throws SQLException {
        // Test with H2 in-memory database
        String url = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";
        
        JdbcConnectionManager manager = new JdbcConnectionManager(url, username, password);
        
        Connection connection = manager.getConnection();
        assertNotNull(connection);
        assertFalse(connection.isClosed());
        
        manager.closeConnection(connection);
        assertTrue(connection.isClosed());
    }

    @Test
    void testGettersAndSetters() {
        String url = "jdbc:h2:mem:testdb";
        String username = "testuser";
        String password = "testpass";
        
        JdbcConnectionManager manager = new JdbcConnectionManager(url, username, password);
        
        assertEquals(url, manager.getUrl());
        assertEquals(username, manager.getUsername());
        assertEquals(password, manager.getPassword());
        
        // Test setters
        manager.setUrl("jdbc:h2:mem:newdb");
        manager.setUsername("newuser");
        manager.setPassword("newpass");
        
        assertEquals("jdbc:h2:mem:newdb", manager.getUrl());
        assertEquals("newuser", manager.getUsername());
        assertEquals("newpass", manager.getPassword());
    }

    @Test
    void testCloseNullConnection() {
        JdbcConnectionManager manager = new JdbcConnectionManager("", "", "");
        // Should not throw exception when closing null connection
        assertDoesNotThrow(() -> manager.closeConnection(null));
    }
}
