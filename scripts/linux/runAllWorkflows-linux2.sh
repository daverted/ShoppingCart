java -Xms2G -Xmx2G -Xshare:off -XX:-UseTypeSpeculation -agentpath:/opt/takipi/lib/libTakipiAgent.so -Dtakipi.application.name=Catalog -Dtakipi.deployment.name=v10.0 -Dtakipi.etl -Dtakipi.parallax -jar ../../target/shopping-cart-demo-1.0.jar run_mode=ALL_WORKFLOWS continue_running=true workflow1_enabled=true workflow2_enabled=true workflow3_enabled=true workflow4_enabled=true workflow5_enabled=true workflow6_enabled=true workflow7_enabled=true workflow8_enabled=true workflow9_enabled=true workflow10_enabled=false workflow11_enabled=false workflow12_enabled=true workflow13_enabled=true workflow14_enabled=true url_connect_string=http://ec2-18-191-237-163.us-east-2.compute.amazonaws.com:8080/Orion-1.0/servlets/servlet/Orion-Common