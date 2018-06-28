package executer_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Class_IsSingleThreadPool {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newSingleThreadExecutor();//1,1,0L,LinkedBlockingQueue();
		Service1 s1=new Service1();
		//Service1 s2=new Service1();
		
		service.submit(s1);
		//service.submit(s2);
		
		System.out.println(" Main method Before :"+service.isTerminated());
		
		service.shutdownNow();
		service.awaitTermination(5, TimeUnit.SECONDS);
		while(service.isTerminated())
		{
			
		}
		System.out.println("Main Method Terminated :"+service.isTerminated());
		System.out.println(" Main Method Completed...");
		
		
	}

}
class Service1 implements Runnable
{

	@Override
	public void run() {
		for(int i=1;i<10;i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" producing :-"+i);
		}
	}
	
}