package org.nuxeo.sample.test;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.LocalDeploy;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.ecm.platform.ec.notification.service.NotificationService;
import org.nuxeo.sample.MyTargetExtension;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy({"org.nuxeo.ecm.platform.notification.core"})                        
@PartialDeploy(bundle = "studio.extensions.partialdeploytest-suppor", extensions = { MyTargetExtension.class })
@LocalDeploy({"org.nuxeo.sample.studio.test:OSGI-INF/notification-contrib.xml"})
public class TestMyProject {
    @Test
    public void hello() {

    	URL localTestTemplate = NotificationService.getTemplateURL("localTestTemplate");
        assertTrue(localTestTemplate.getFile().endsWith("templates/test.ftl"));
        
        URL fromStudioTemplate = NotificationService.getTemplateURL("appReviewStarted");
        assertTrue(fromStudioTemplate.getFile().endsWith("templates/appReviewStarted.ftl"));
    }
}
