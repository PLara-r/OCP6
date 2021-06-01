# OCP6

Таблица 6.1 Типы исключений
Тип   	                                Как распознать                   	Хорошо для программы, чтобы поймать?            	Требуется ли программа для обработки или объявления?
Исключение во время выполнения	        Подкласс RuntimeException	       да	                                              нет
Проверенное исключение	                Подкласс,Exceptionно не подклассRuntimeException	да	                             да
ошибка	                                Подкласс Error	                 нет	                                               нет


Исключение означает, что произошло нечто неожиданное. Метод может обработать исключение, перехватив его или объявив, что вызывающая сторона имеет дело с ним.
Многие исключения генерируются библиотеками Java. Вы можете выдать собственное исключение с помощью кода, такого как throw new Exception().
Подклассы java.lang.Errorявляются исключениями, которые программист не должен пытаться обрабатывать. Подклассы java.lang.RuntimeExceptionявляются исключениями времени выполнения
(непроверенными).
Подклассы java.lang.Exception, но не java.lang.RuntimeExceptionявляются проверенными исключениями. Java требует, чтобы проверенные исключения были обработаны или объявлены.

Если tryоператор имеет несколько catchблоков, catchможет выполняться не более одного блока. Java ищет исключение, которое может быть перехвачено каждым catchблоком
в порядке их появления, и выполняется первое совпадение. Затем выполнение продолжается после tryутверждения. Если оба catchи finallyвыбрасывают исключение,
то один из finallyбросается.

Общие исключения времени выполнения включают в себя:
•	ArithmeticException
•	ArrayIndexOutOfBoundsException
•	ClassCastException
•	IllegalArgumentException
•	NullPointerException
•	NumberFormatException

IllegalArgumentExceptionи NumberFormatExceptionобычно выбрасываются программистом, тогда как другие обычно выбрасываются JVM.
Общие проверенные исключения включают в себя:
•	IOException
•	FileNotFoundException
Распространенные ошибки включают в себя:
•	ExceptionInInitializerError
•	StackOverflowError
•	NoClassDefFoundError
Когда метод переопределяет метод в суперклассе или интерфейсе, ему не разрешается добавлять проверенные исключения.
Разрешается объявлять меньшее количество исключений или подкласс объявленного исключения. Методы объявляют исключения с ключевым словом throws.

р.s. для ОСР еще 7 исключений

Multi-catch
позволяет перехватывать несколько типов исключений в одном catchблоке.
Типы разделяются с помощью трубы ( |). Множественные типы исключений не могут иметь отношения подкласс / суперкласс.
Переменная в выражении multi-catch по сути является окончательной.


Try-with-resources 
позволяет Java позаботиться о вызове close()метода. Это называется автоматическим управлением ресурсами.
Объекты, созданные в tryпредложении, должны реализовывать AutoCloseableинтерфейс.
Этот интерфейс имеет единственный метод close()и может генерировать любой тип Exception. В отличие от традиционных tryоператоров,
try-with-resources не требует наличия блока catchили finally.

Если tryпредложение и один или несколько close()методов выдают исключение, Java использует подавленные исключения для отслеживания обоих.
Точно так же, если несколько close()методов выдают исключение, первый является основным, а остальные - исключенными. getSuppressed()позволяет получить эти исключения.

 Допустимые и недопустимые конфигурации с традиционным try утверждением
	                                            0 finally блоков	                                  1 finally блок	                                 2 или более finally блоков
0  catch блоков	                                   Не законно                                    	легальный	                                       Не законно
1 или более  catch блоков	                        легальный	                                        легальный                                         	Не законно

Допустимые и недопустимые конфигурации с оператором try-with-resources

	                                            0 finally блоков	                                    1 finally блок	                                 2 или более finally блоков
0  catch блоков	                              легальный	                                           легальный	                                       Не законно
1 или более  catch блоков                    	легальный	                                           легальный	                                       Не законно
