/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author George.Pasparakis
 */
public class DBConnectionOptions {
    private String host;
    private String hostPort;
    private String username; 
    private String password;
    private String database;
    private String dbOptions;

    public DBConnectionOptions() {
    }

    public DBConnectionOptions(String host, String hostPort, String username, String password, String database, String dbOptions) {
        this.host = host;
        this.hostPort = hostPort;
        this.username = username;
        this.password = password;
        this.database = database;
        this.dbOptions = dbOptions;
    }

    public String getDbOptions() {
        return dbOptions;
    }

    public void setDbOptions(String dbOptions) {
        this.dbOptions = dbOptions;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.host);
        hash = 73 * hash + Objects.hashCode(this.hostPort);
        hash = 73 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 73 * hash + Objects.hashCode(this.database);
        hash = 73 * hash + Objects.hashCode(this.dbOptions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBConnectionOptions other = (DBConnectionOptions) obj;
        if (!Objects.equals(this.host, other.host)) {
            return false;
        }
        if (!Objects.equals(this.hostPort, other.hostPort)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.database, other.database)) {
            return false;
        }
        if (!Objects.equals(this.dbOptions, other.dbOptions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DBConnectionOptions{host=").append(host);
        sb.append(", hostPort=").append(hostPort);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", database=").append(database);
        sb.append(", dbOptions=").append(dbOptions);
        sb.append('}');
        return sb.toString();
    }
}
