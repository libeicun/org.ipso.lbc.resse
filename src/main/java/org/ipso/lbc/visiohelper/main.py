__author__ = 'lbc'

import sys, win32com.client

args = sys.argv
docs = sys.argv[1:]
visio = win32com.client.Dispatch("Visio.Application")
all = visio.Documents.Open("f:\\all.vsdx")
test = visio.Documents.Open("f:\\test\\test.vsdx")

try:
    visio.Visible = 0
    pages = all.Pages
    for p in test.Pages:
        pages.AddPage(p)
    # try:
    #     dwg = visio.Documents.Open(doc)
    #     print dwg.TimeCreated, ",", dwg.TimeSaved
    # except Exception, e:
    #     print "Error", e
    all.Close()
    visio.Quit()
except Exception, e:
    all.Close()
    test.Close()
    visio.Quit()
    print "Error opening file",e