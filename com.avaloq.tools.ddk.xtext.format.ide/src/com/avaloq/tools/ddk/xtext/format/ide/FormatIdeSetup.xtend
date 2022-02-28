/*
 * generated by Xtext 2.25.0
 */
package com.avaloq.tools.ddk.xtext.format.ide

import com.avaloq.tools.ddk.xtext.format.FormatRuntimeModule
import com.avaloq.tools.ddk.xtext.format.FormatStandaloneSetup
import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class FormatIdeSetup extends FormatStandaloneSetup {

  override createInjector() {
    Guice.createInjector(Modules2.mixin(new FormatRuntimeModule, new FormatIdeModule))
  }

}
