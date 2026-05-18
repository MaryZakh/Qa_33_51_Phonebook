package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().withEmail("margo@gmail.com").withPassword("Mmar123456$"));
    }

    @Test
    public void addNewContactSuccessAllFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("Tony" + i)
                .lastName("Molly")
                .phone("34343434" + i)
                .email("molly" + i + "@gmail.com")
                .address("Haifa")
                .description("all fields")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(10000);
        app.getHelperContact().getScreen("src/test/screenshots/screen -"+i+".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactSuccessRequiredFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("TonyReq")
                .lastName("Molly")
                .phone("34343434" + i)
                .email("molly" + i + "@gmail.com")
                .address("Haifa")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Molly")
                .phone("343434343434")
                .email("molly@gmail.com")
                .address("Haifa")
                .description("empty name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .phone("343434343434")
                .email("molly@gmail.com")
                .address("Haifa")
                .description("empty last name")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
       // app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Molly")
                .phone("343434343434")
                .email("mollygmail.com")
                .address("Haifa")
                .description("wrong email")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
       // app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Email not valid:"));
    }

    @Test
    public void addNewContactWrongPhone() {
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Molly")
                .phone("")
                .email("molly@gmail.com")
                .address("Haifa")
                .description("empty phone")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
       // app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact().isAlertPresent("Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Molly")
                .phone("343434343434")
                .email("molly@gmail.com")
                .address("")
                .description("empty address")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
       // app.getHelperContact().pause(10000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
    }
}
