package utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

public class VelocityUtil {
    private static final String ENCODING = "UTF-8";
    private static VelocityEngine velocityEngine = null;

    /**
     *
     * @return
     */
    private static VelocityEngine getVelocityEngine() {
        if (velocityEngine == null) {
            velocityEngine = new VelocityEngine();
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file,classpath");
            velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        }
        return velocityEngine;
    }


    public static String templateMerge(String templateName, VelocityContext vc) {
        StringWriter ow = new StringWriter();
        getVelocityEngine().getTemplate(templateName, ENCODING).merge(vc, ow);
        return ow.toString();
    }
}
