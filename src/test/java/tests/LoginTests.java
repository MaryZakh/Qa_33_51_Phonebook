package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //If button Sign Out present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finished logout");
        }
    }

    @Test
    public void loginSuccess1 (){
        User user =new User().withEmail("margo@gmail.com").withPassword("Mmar123456$");
//        user.setEmail("margo@gmail.com");
//        user.setPassword("Mmar123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

  @Test
  public void loginSuccess (){
   logger.info("Start test with name 'loginSuccess'");
   logger.info("Test data---> email: 'margo@gmail.com' & password: 'Mmar123456$'");
   app.getHelperUser().openLoginRegistrationForm();
   app.getHelperUser().fillLoginRegistrationForm("margo@gmail.com","Mmar123456$");
   app.getHelperUser().submitLogin();

   //Assert
//      Assert.assertEquals();
//      Assert.assertNotEquals();
//      Assert.assertTrue();
//      Assert.assertFalse();

      Assert.assertTrue(app.getHelperUser().isLogged());
      logger.info("Assert check is element button 'Sign out' present");
  }

    @Test
    public void loginSuccessModel (){
        logger.info("Test data---> email: 'margo@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("margo@gmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        //Assert
//      Assert.assertEquals();
//      Assert.assertNotEquals();
//      Assert.assertTrue();
//      Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data---> email: 'margogmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("margogmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data---> email: 'margo@gmail.com' & password: 'Mmar123'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("margo@gmail.com","Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data---> email: 'margo_m@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("margo_m@gmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }





}
