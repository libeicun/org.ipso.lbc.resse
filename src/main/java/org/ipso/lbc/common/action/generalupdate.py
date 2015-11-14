# -*- coding: utf-8 -*-
__author__ = 'hsu'


import os
import datetime
import dbconn
import sys

reload(sys)
sys.setdefaultencoding('utf-8')
args = sys.argv
try:

    conn = dbconn.getAccessConn(args[1])
    params = args[2:18]
    dbconn.delete(conn, "GENERAL_INFO", "ID", params[0])
    dbconn.insert(conn, "GENERAL_INFO", params)
    print "SUCCESS!\n"
except Exception, err:
    print u"ERROR!\n"
    print err



