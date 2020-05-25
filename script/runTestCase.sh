#!/bin/bash
echo "****start*****"
mvn install
mvn install -Dxmlfilename=testng.xml
echo "****end*****"

