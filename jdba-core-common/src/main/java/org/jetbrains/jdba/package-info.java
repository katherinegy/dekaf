/**
 * JDBA — Java Database Access Layer Framework
 *
 * <p>
 *   Provides easy and clear access to databases.
 *   See <a href="http://github.com/leo-from-spb/jdba/network">JDBA Framework on GitHub</a>
 * </p>
 *
 * <p>
 *   Inner packages:
 *   <ol>
 *     <li><b>core</b>: core and client-side interfaces and classes; client code should use this package.</li>
 *     <li><b>inter</b>: interfaces and classes that are on an 'intermediate' layer (between JDBA and vendor-provided API).</li>
 *     <li><b>jdbc</b>: classes that uses JDBC (RDBMS vendor provided API) and implements intermediate interfaces.</li>
 *     <li><b>exceptions</b>: exceptions classes.</li>
 *     <li><b>util</b>: some utility functions.</li>
 *   </ol>
 * </p>
 *
 * <p>
 *   This package also contains RDBMS markers.
 * </p>
 *
 * @author Leonid Bushuev from JetBrains
 */
package org.jetbrains.jdba;