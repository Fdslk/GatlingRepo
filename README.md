# GatlingRepo

    load test by Gatling in this repo, you will know how to use gatling to do load test

* preparation
  * download gatling
  * unzip your gatling zip file
  * use the cmd
    ```/Users/zengqiangfang/Downloads/software/gatling-charts-highcharts-bundle-3.7.5/bin```
  * execute ./recorder.sh (in mac) will open the following GUI
    ![gatling recorder GUI](https://user-images.githubusercontent.com/6279298/155526456-aa122499-b148-4f66-ab8b-56a6be3f898b.jpg)

  * then go to a website [computer-database](https://computer-database.gatling.io/).
    * open the developer model of your browser
    * check the presave-log operation
    * doing the following operations
      * reload home page
      * open creating page
      * create new computer entity
      * search new computer by its names
    * save HAR file
    * using Gatling to generate scala file
    * execute ./gatling.sh
    * ![see new scala file](https://user-images.githubusercontent.com/6279298/155529006-2848927d-0b5f-49ca-8e4d-28921972e574.png)

    * generate test report
    ![test report](https://user-images.githubusercontent.com/6279298/155529293-a44863d0-eca7-432f-904f-d774159c4789.png)

    * so far, you might know how to use gatling to do a simple test.
