package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @Test
  public void loginSuccess (){
   app.getHelperUser().openLoginRegistrationForm();
   app.getHelperUser().fillLoginRegistrationForm("margo@gmail.com","Mmar123456$");
   app.getHelperUser().submitLogin();

   //Assert
//      Assert.assertEquals();
//      Assert.assertNotEquals();
//      Assert.assertTrue();
//      Assert.assertFalse();
  }

}
