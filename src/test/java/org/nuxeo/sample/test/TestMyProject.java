package org.nuxeo.sample.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.stream.IntStream;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.automation.AutomationService;
import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.OperationException;
import org.nuxeo.ecm.automation.test.AutomationFeature;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.LocalDeploy;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;
import org.nuxeo.ecm.platform.ec.notification.service.NotificationService;
import org.nuxeo.sample.MyTargetExtension;
import java.net.URL;

@RunWith(FeaturesRunner.class)
//@Features({ RestServerFeature.class })
@Features({ PlatformFeature.class })
//@Deploy({"org.nuxeo.ecm.platform.notification.core","org.nuxeo.ecm.platform.ws"})                        
@Deploy({"org.nuxeo.ecm.platform.notification.core"})                        
//@PartialDeploy(bundle = "studio.extensions.hbrown-SANDBOX", extensions = { MyTargetExtension.class, TargetExtensions.Automation.class })
@PartialDeploy(bundle = "studio.extensions.hbrown-SANDBOX", extensions = { MyTargetExtension.class })
@LocalDeploy({"org.nuxeo.sample.studio.test:OSGI-INF/notification-contrib.xml"})
public class TestMyProject {
    @Test
    public void hello() {
        URL newModifTemplate = NotificationService.getTemplateURL("tt");
        assertTrue(newModifTemplate.getFile().endsWith("templates/test.ftl"));
        URL zzTemplate = NotificationService.getTemplateURL("zz");
        assertTrue(zzTemplate.getFile().endsWith("templates/zz.ftl"));
    }
}
