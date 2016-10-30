#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def addpackage(filename):
	with open(filename, "r+") as file:
		content = file.read()
		file.seek(0)
		file.write("package org.tisong.stdlib;\n" + content)

import os

filenames = os.listdir("./")
for fn in filenames:
	if (os.path.splitext(fn)[1] == '.java'):
		addpackage(fn)

subprocess.call("javac *.java", shell= True)
subprocess.call("jar cf *.class stdlib.jar")

