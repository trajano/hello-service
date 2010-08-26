/**
 * <h1>Vendor Dependencies</h1>
 * 
 * <h2>Spring</h2>
 * <p>I chose Spring as a vendor dependence because out of all the IoC containers I have used, this seems to have the most documentation and examples.  It seems to be more well known in my circle and customers I support.</p>
 * <p>I normally like PicoContainer just because it is simple, but it is not something I can give to someone who does "good enough in their own eyes" work to maintain.</p>
 * <p>JEE Injection is too limited, and does not really have good AOP examples for logging.  Testability of configurations is also difficult without a container.</p>
 * 
 * <h2>Log4J</h2>
 * <p>For logging purposes, I prefer log4j on top of commons-logging overall the options available.</p>
 * <p>Log4J and commons-logging may be old, but it is because of its age that make it more established among larger customers.  Like Spring, it has become a buzzword that can be kicked around by people who don't really know what they are doing (it happens), but at least it is better than someone that custom makes everything based on using "design patterns" as a buzzword.
 * <p>Personally, SLF4J and Logback are cleaner, but in the end consistency with the rest of the enterprise operations is more important.</p> 
 */
package net.trajano.ws.helloservice.impl;