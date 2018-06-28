package executer_Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo_Executer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=Executors.newFixedThreadPool(4);
		Execute1 e1=new Execute1();
		Execute1 e2=new Execute1();
		Execute1 e3=new Execute1();
		Execute1 e4=new Execute1();
		
	//	System.out.println(l);
		service.execute(e1);
		service.execute(e2);
		service.execute(e3);
		service.execute(e4);
		
		List l=service.shutdownNow();
		boolean b=service.isShutdown();
		System.out.println(b);
		//service.shutdown();
	}

}
class Execute1 implements Runnable{

	@Override
	public void run() {
		for(int i=1;i<=5;i++)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"Execute Service:"+i);
		}
		
	}
	
}
class Execute2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"Execute Service:"+i);
		}
	}
	
}