/*
 * generated by Xtext 2.26.0
 */
package com.avaloq.tools.ddk.xtext.scope.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ScopeAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("com/avaloq/tools/ddk/xtext/scope/parser/antlr/internal/InternalScope.tokens");
	}
}
