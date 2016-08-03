/**
 * Copyright (C) 2015 NeroBurner; Copyright (C) 2016 JingxuanMan
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation in version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * This driver is part of the OpenJEVis project, further project information are
 * published at <http://www.OpenJEVis.org/>.
 */
package org.jevis.sqldatasource;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NeroBurner (AIT)
 * @author JingxuanMan (Envidatec)
 */
public class MySQLDataSource extends SQLDriverAbstract {

    @Override
    public String loadJDBC(String host, int port, String schema, String dbUser, String dbPW,
            String domain) throws ClassNotFoundException, SQLException {

        Logger.getLogger(MySQLDataSource.class.getName()).log(Level.INFO, "MySQLDataSource loadJDBC Version 2017-08-02");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + schema + "?";
        _con = DriverManager.getConnection(url, dbUser, dbPW);
        return url;
    }

    interface MySQL extends SQLDriverAbstract.SQLServer {

        public final static String NAME = "MySQL Server";
    }

    @Override
    protected String getClassName() {
        return MySQL.NAME;
    }
}
