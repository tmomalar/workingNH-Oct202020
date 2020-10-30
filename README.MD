docker build -t autoimmunetest .
docker run --volume ${PWD}/:/app/ -it autoimmunetest:latest  bash
To Run the Tests mvn clean test -Dtest=SecurityTest
To Run in local with browser open use - mvn clean test -Dtest=SecurityTest -Dwebdriver.class=org.openqa.selenium.chrome.ChromeDriver -Dwebdriver.chrome.driver=C:/tools/chrome86/chromedriver.exe