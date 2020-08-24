import java.net.InetAddress; 

public aspect InetResolverAspect {

    pointcut callGetByName(String host) : 
      call(java.net.InetAddress java.net.InetAddress.getByName(String)) && args(host) && target (java.net.InetAddress); 

    before (String host) : callGetByName(host) {
        // System.out.println(String.format("$$$ hostname request %s", host)) ; 
        throw new RuntimeException (host) ;

    }

    java.net.InetAddress around( String host ) :callGetByName(host) {
        return proceed (host); 
    }
}