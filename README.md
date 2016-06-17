# TaskPicker

TaskPicker (TaskManager) побудований по принципу IoC - Inversion of Control, що дозволяє передати процес ініціалізації обєктів на 
на якийсь зовнішній (або локальний) фрейморк

Фреймворк автоматично ініціалізує обєкти і представляє доступ до них через графічний інтерфейс користувача.


Як створити Task

1) створити обєкт типу AbstractTask.java і перевизначити абстрактний метод returnCalculatedOutput()
тобто обєкт який повертається при виконанні нашої задачі (Object/String/Integer/int[] .......)

приклад:


public class MyHomeWork extends AbstractTask {
	
	Random rand = new Random();
	
	public int calcSum(){
		
		int sum=0;
		
		final int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = rand.nextInt(100);
		}
		for(int elem: arr){
			
			if(elem%5 == 0 && elem %7 !=0){
				sum+=elem;
			}
		}
		return sum;
		
	}
	
	@Override
	public Object returnCalculatedOutput() {
		return calcSum();
		
	}
	
	2) прописати необхідні атрибути у файлі task_names.xml
	
    <task>
    	<id>task 199</id>
    	<name>com.softserveinc.edu.ita.taskmanager.model.MyHomeWork</name>
    	<description>find sum of elements equally divided by 5</description>
    </task>
    
    
.... і все.... запустити задачу та насолоджуватися роботою!
	
	
