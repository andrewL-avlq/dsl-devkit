/*******************************************************************************
 * Copyright (c) 2016 Avaloq Group AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Avaloq Group AG - initial API and implementation
 *******************************************************************************/
package com.avaloq.tools.ddk.test.core.junit.runners;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import com.avaloq.tools.ddk.test.core.BugTest;
import com.avaloq.tools.ddk.test.core.Issue;
import com.avaloq.tools.ddk.test.core.Issues;


/**
 * A test filter that makes sure only tests for unresolved issues are run.
 * <p>
 * The filter checks if any of the related issues is unresolved. If there are no related issues specified, the test is not run.
 * </p>
 */
public class UnresolvedIssueFilter extends Filter {

  @Override
  public boolean shouldRun(final Description description) {
    if (FilterRegistry.isSuite(description)) {
      return true;
    }
    // else: test class or test method
    final Issues issuesAnnotation = description.getAnnotation(Issues.class);
    if (issuesAnnotation != null) {
      for (final Issue issueAnnotation : issuesAnnotation.value()) {
        if (issueAnnotation != null && !issueAnnotation.fixed()) {
          return true;
        }
      }
    }
    final Issue issueAnnotation = description.getAnnotation(Issue.class);
    if (issueAnnotation != null && !issueAnnotation.fixed()) {
      return true;
    }
    final BugTest bugTestAnnotation = description.getAnnotation(BugTest.class);
    if (bugTestAnnotation != null && bugTestAnnotation.unresolved()) { // NOPMD SimplifyBooleanReturns
      return true;
    }
    return FilterRegistry.isTestClass(description); // if it is a test class we still want to check (and maybe run) its children
  }

  @Override
  public String describe() {
    return UnresolvedIssueFilter.class.getSimpleName();
  }
}
