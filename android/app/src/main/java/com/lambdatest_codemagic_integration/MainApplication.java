package com.lambdatest_codemagic_integration;

// import android.app.Application;
// import android.content.Context;
// import com.facebook.react.PackageList;
// import com.facebook.react.ReactApplication;
// import com.facebook.react.ReactInstanceManager;
// import com.facebook.react.ReactNativeHost;
// import com.facebook.react.ReactPackage;
// import com.facebook.soloader.SoLoader;
// import java.lang.reflect.InvocationTargetException;
// import java.util.List;

// public class MainApplication extends Application implements ReactApplication {

//   private final ReactNativeHost mReactNativeHost =
//       new ReactNativeHost(this) {
//         @Override
//         public boolean getUseDeveloperSupport() {
//           return BuildConfig.DEBUG;
//         }

//         @Override
//         protected List<ReactPackage> getPackages() {
//           @SuppressWarnings("UnnecessaryLocalVariable")
//           List<ReactPackage> packages = new PackageList(this).getPackages();
//           // Packages that cannot be autolinked yet can be added manually here, for example:
//           // packages.add(new MyReactNativePackage());
//           return packages;
//         }

//         @Override
//         protected String getJSMainModuleName() {
//           return "index";
//         }
//       };

//   @Override
//   public ReactNativeHost getReactNativeHost() {
//     return mReactNativeHost;
//   }

//   @Override
//   public void onCreate() {
//     super.onCreate();
//     SoLoader.init(this, /* native exopackage */ false);
//     initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
//   }

//   /**
//    * Loads Flipper in React Native templates. Call this in the onCreate method with something like
//    * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
//    *
//    * @param context
//    * @param reactInstanceManager
//    */
//   private static void initializeFlipper(
//       Context context, ReactInstanceManager reactInstanceManager) {
//     if (BuildConfig.DEBUG) {
//       try {
//         /*
//          We use reflection here to pick up the class that initializes Flipper,
//         since Flipper library is not available in release mode
//         */
//         Class<?> aClass = Class.forName("com.lambdatest_codemagic_integration.ReactNativeFlipper");
//         aClass
//             .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
//             .invoke(null, context, reactInstanceManager);
//       } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//       } catch (NoSuchMethodException e) {
//         e.printStackTrace();
//       } catch (IllegalAccessException e) {
//         e.printStackTrace();
//       } catch (InvocationTargetException e) {
//         e.printStackTrace();
//       }
//     }
//   }
// }


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An {@link Activity} that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the listeners for the buttons.
        findViewById(R.id.changeTextBt).setOnClickListener(this);
        findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textToBeChanged);
        mEditText = (EditText) findViewById(R.id.editTextUserInput);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        final int changeTextBtId = R.id.changeTextBt;
        final int activityChangeTextBtnId = R.id.activityChangeTextBtn;

        if (view.getId() == changeTextBtId) {
          // First button's interaction: set a text in a text view.
          mTextView.setText(text);
        } else if (view.getId() == activityChangeTextBtnId) {
          // Second button's interaction: start an activity and send a message to it.
          Intent intent = com.example.android.testing.espresso.BasicSample.ShowTextActivity
              .newStartIntent(this, text);
          startActivity(intent);
        }
    }
}




// import java.net.URL;
// import java.util.List;
// import java.net.MalformedURLException;
// import io.appium.java_client.MobileBy;
// import io.appium.java_client.MobileElement;
// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.android.AndroidElement;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.remote.DesiredCapabilities;
// public class AndroidApp {
// public static String userName = "nihalnevercode";
// public static String accessKey = "tZAy17ivs9JlLPDqjB3n3sZxZq3K1SzPmaGwOFNddEG9kdYeJt";
// public static void main(String args[]) throws MalformedURLException, InterruptedException {
// DesiredCapabilities capabilities = new DesiredCapabilities();
// capabilities.setCapability("platformName", "Android");
// capabilities.setCapability("deviceName", "Google Pixel 3");
// capabilities.setCapability("isRealMobile", true);
// capabilities.setCapability("platformVersion","10");
// capabilities.setCapability("app","lt://APP100201711643634891400553");
// capabilities.setCapability("deviceOrientation", "PORTRAIT");
// capabilities.setCapability("console",true);
// capabilities.setCapability("network",true);
// capabilities.setCapability("visual",true);
// RemoteWebDriver driver = new RemoteWebDriver(new
// URL("https://"+userName+":"+accessKey+"@beta-hub.lambdatest.com/wd/hub"), capabilities);
// try {
// AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
// ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search
// Wikipedia")));
// searchElement.click();
// AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
// ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
// insertTextElement.sendKeys("LambdaTest"+ Keys.ENTER);
// Thread.sleep(5000);
// List allProductsName = driver.findElementsByClassName("android.widget.TextView");
// assert(allProductsName.size() > 0);
// ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
// }catch (Exception e){
// ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
// e.printStackTrace();
// }catch (AssertionError a){
// ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
// a.printStackTrace();
// }
// // The driver.quit statement is required, otherwise the test continues to execute, leading
// to a timeout.
// driver.quit();
// }
// }