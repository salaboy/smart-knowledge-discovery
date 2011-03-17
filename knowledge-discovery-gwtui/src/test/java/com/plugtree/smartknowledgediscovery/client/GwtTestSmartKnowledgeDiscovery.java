package com.plugtree.smartknowledgediscovery.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * GWT JUnit <b>integration</b> tests must extend GWTTestCase.
 * Using <code>"GwtTest*"</code> naming pattern exclude them from running with
 * surefire during the test phase.
 */
public class GwtTestSmartKnowledgeDiscovery extends GWTTestCase {

  /**
   * Must refer to a valid module that sources this class.
   */
  @Override
  public String getModuleName() {
      return "com.plugtree.smartknowledgediscovery.SmartKnowledgeDiscoveryJUnit";
  }
}
