package org.nuxeo.sample.test;
import static org.junit.Assert.assertEquals;

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
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;
import org.nuxeo.ecm.platform.ec.notification.service.NotificationService;
import org.nuxeo.sample.MyTargetExtension;

@RunWith(FeaturesRunner.class)
@Features({ AutomationFeature.class })
@PartialDeploy(bundle = "studio.extensions.hbrown-SANDBOX", extensions = { MyTargetExtension.class, TargetExtensions.Automation.class })
public class TestMyProject {
    @Test
    public void hello() {
        System.out.println("HI");
    }
}
