package datos1.tec.org.packettec;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import connections.HttpRequest;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        HttpRequest request = new HttpRequest();
        request.post("http://192.168.100.5:9080/webapi/services/messages", "{\"receiver\":\"Contact\",\"body\":\"mensaje\",\"sender\":\"Jasson\"}");

        assertEquals("200", request.getResponse());
    }
}
