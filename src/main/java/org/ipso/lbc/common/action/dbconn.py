# -*- coding: utf-8 -*-
__author__ = 'hsu'
import pypyodbc

def getAccessConn(path):
    conn = pypyodbc.win_connect_mdb(path)
    return conn

def delete(conn, tableName, pkey, pvalue):
    cursor = conn.cursor()
    sql = " delete from " + tableName + " where " + pkey + " = ? "
    cursor.execute(sql,pvalue)
    conn.commit()

def insert(conn, tableName, datas):
    size = length(datas)
    params = " VALUES("
    for i in range(0, size):
        params = params + '?,'
    params = params[0:length(params-1)] + ")"
    cursor = conn.cursor()
    sql = "insert into " + tableName + params
    cursor.execute(sql, datas)

    cursor.commit()





