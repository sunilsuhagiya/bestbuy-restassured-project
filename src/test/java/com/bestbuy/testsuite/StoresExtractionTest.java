package com.bestbuy.testsuite;

import com.sun.javafx.scene.control.SizeLimitedList;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.plugin2.os.windows.Windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

//    1. Extract the limit
    @Test
    public void test001(){
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }
//    2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
//    3. Extract the name of 5th store
    @Test
    public void test003(){
        String storeName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }
//    4. Extract the names of all the store
@Test
public void test004(){
    List<String> listStoreName = response.extract().path("data.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of all the store is : " + listStoreName);
    System.out.println("------------------End of Test---------------------------");
}
//    5. Extract the storeId of all the store
    @Test
    public void test005(){
        List<Integer> listStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is : " + listStoreId);
        System.out.println("------------------End of Test---------------------------");
    }
//    6. Print the size of the data list
    @Test
    public void test006(){
       int dataList = response.extract().path("data.size()");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + dataList);
        System.out.println("------------------End of Test---------------------------");
    }
//    7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007(){
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name = St Cloud are: " +values);
        System.out.println("------------------End of Test---------------------------");
    }
//    8. Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<?> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester is: " +address);
        System.out.println("------------------End of Test---------------------------");
    }
//    9. Get all the services of 8th store
    @Test
    public void test009(){
        List<?> serviceList = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the services of 8th store is: " +serviceList);
        System.out.println("------------------End of Test---------------------------");
    }
//    10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010(){
        ArrayList<?> storeServices = response.extract().path("data.findAll{it.name=='Windows Store'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services of windows store is: " +storeServices);
        System.out.println("------------------End of Test---------------------------");
    }
//    11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The all the store Id of all the store is: " +storeIds);
        System.out.println("------------------End of Test---------------------------");
    }
//    12. Get id of all the store
    @Test
    public void test012(){
        List<Integer> ids = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all the store is: " +ids);
        System.out.println("------------------End of Test---------------------------");
    }
//    13. Find the store names Where state = ND
    @Test
    public void test013(){
        List<String> name = response.extract().path("data.findAll{it.name=='ND'}.state");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the store names Where state = ND is: " +name);
        System.out.println("------------------End of Test---------------------------");
    }
//    14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
        List<?> service = response.extract().path("data.findAll{it.store=='Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the total number of services is: " +service);
        System.out.println("------------------End of Test---------------------------");
    }
//    15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){
        ArrayList<HashMap<String, ?>> serviceCreated = response.extract().path("data.findAll{it.name == 'Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the createdAt for all services whose name = Windows Store is: " +serviceCreated);
        System.out.println("------------------End of Test---------------------------");
    }
//    16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<String> fargo = response.extract().path("data.findAll{it.name.startsWith('Fargo').services}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the createdAt for all services whose name = Windows Store is: " +fargo);
        System.out.println("------------------End of Test---------------------------");
    }
//    17. Find the zip of all the store
    @Test
    public void test017(){
        List<?> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of all the store is : " +zip);
        System.out.println("------------------End of Test---------------------------");
    }
//    18. Find the zip of store name = Roseville
    @Test
        public void test018() {
        List<Integer> storeZip = response.extract().path("data.findAll{it.name.startsWith('Roseville')}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of store name Roseville is : " +storeZip);
        System.out.println("------------------End of Test---------------------------");
    }
//    19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<?> storeServices = response.extract().path("data.findAll{it.name.startsWith('Magnolia Home Theater').storeservices}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("store services details of the service name Magnolia Home Theater is : " +storeServices);
        System.out.println("------------------End of Test---------------------------");
    }
//    20. Find the lat of all the stores
    @Test
    public void test020(){
        List<Double> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Lat of all stores is : " +lat);
        System.out.println("------------------End of Test---------------------------");
    }
}
