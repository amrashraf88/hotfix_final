package POM;

import io.restassured.http.ContentType;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Api {
    static String messagedeactive;

    public void deactivedaccountFOREMAIL() {
        int id = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"test.test@test.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("data.id");

        System.out.println("id: " + id);

        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("data.token");

        System.out.println("Token: " + token1);

        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/customers/"+id+"/deactivate")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{ \"deactivation_notes\": \"yes\"}")
                .post()
                .then()
                .statusCode(200);

        String idcustomer = String.valueOf(id);
        System.out.println("idcustomer: " + idcustomer);

        // Clear file contents before writing idcustomer value to a file
        String fileName = "idcustomergmail.txt";
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(idcustomer);
            writer.close();
            System.out.println("Successfully wrote idcustomer value to file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing idcustomer value to file " + fileName);
            e.printStackTrace();
        }
    }
    public void deactivedaccount() {
        int id = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"phone\": \"010623883\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("data.id");

        System.out.println("id: " + id);

        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("data.token");

        System.out.println("Token: " + token1);

        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/customers/"+id+"/deactivate")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{ \"deactivation_notes\": \"yes\"}")
                .post()
                .then()
                .statusCode(200);

        String idcustomer = String.valueOf(id);
        System.out.println("idcustomer: " + idcustomer);

        // Clear file contents before writing idcustomer value to a file
        String fileName = "idcustomer.txt";
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(idcustomer);
            writer.close();
            System.out.println("Successfully wrote idcustomer value to file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing idcustomer value to file " + fileName);
            e.printStackTrace();
        }
    }
    public void activedaccount() {
        // Read idcustomer value from file
        String fileName = "idcustomer.txt";
        String iduserInt = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            iduserInt = reader.readLine();
            reader.close();
            System.out.println("Successfully read idcustomer value from file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading idcustomer value from file " + fileName);
            e.printStackTrace();
        }

        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("data.token");

        System.out.println("Token: " + token1);
        System.out.println(iduserInt);

        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/customers/" + iduserInt + "/activate")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{}")
                .post()
                .then()
                .statusCode(200);
    }
    public static void deleteMyAccountByemail() {
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"010623883\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("{\"message\":\"The phone field is required\",\"message_ar\":\"The phone field is required\",\"errors\":{\"0\":\"The given data was invalid.\",\"errorMessage\":\"Invalid Data\",\"errorDetails\":{\"phone\":[\"The phone field is required\"]}},\"code\":423}"));
    }
    public static void loginacountbyphone() {
        int id=given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"phone\": \"010623883\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()

                .path("data.id");
        System.out.println("id: " + id);

    }
    public static void openphone() {
        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)

                .extract()

                .path("data.token");

        System.out.println("Token: " + token1);
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/configurations/manager/update")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{ \"configs\": [ { \"id\": 359, \"value\": \"https://api.whatsapp.com/send/?phone=xxxxxx\" }, { \"id\": 181, \"value\": true } ] }")
                .post()
                .then()
                .statusCode(200);


    }
    public static void openemail() {
        String token1 = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"admin@el-dokan.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)

                .extract()

                .path("data.token");

        System.out.println("Token: " + token1);
        given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/admin/configurations/manager/update")
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token1)
                .body("{ \"configs\": [ { \"id\": 359, \"value\": \"https://api.whatsapp.com/send/?phone=xxxxxx\" }, { \"id\": 181, \"value\": false } ] }")
                .post()
                .then()
                .statusCode(200);


    }
    public static void checkloginbyemail() {

        String expectedMessage = "Your account has been deactivated, please contact the support.";
        String actualMessage = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"email\": \"test.test@test.com\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("message");
        System.out.println("message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    public static void checkloginbyphone() {
        String expectedMessage = "Your account has been deactivated, please contact the support.";
        String actualMessage = given()
                .baseUri("https://shopapi.witheldokan.com")
                .basePath("/api/customer/auth")
                .contentType(ContentType.JSON)
                .body("{ \"phone\": \"010623883\", \"password\": \"12345678\" }")
                .post()
                .then()
                .statusCode(200)
                .extract()
                .path("message");
        System.out.println("message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
