package org.nuxeo.sample.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.LocalDeploy;
import org.nuxeo.runtime.test.runner.PartialDeploy;
import org.nuxeo.runtime.test.runner.TargetExtensions;

@RunWith(FeaturesRunner.class)
@Features(PlatformFeature.class)
@PartialDeploy(bundle = "studio.extensions.partialdeploytest-suppor", extensions = { TargetExtensions.ContentModel.class })
public class TestMyProject {
    @Inject
    protected CoreSession session;

    @Before
    public void setUp() {
        DocumentModel fil1 = session.createDocumentModel("/", "test", "CustomFile");
        fil1 = session.createDocument(fil1);
        session.followTransition(new PathRef("test"), "to_archived");
        session.save();
    }

    @Test
    public void run() {
        DocumentModel doc = session.getDocument(new PathRef("/test"));
        String lifeCycle = doc.getCurrentLifeCycleState();
        assertEquals(lifeCycle, "archived"); 
    }
}
