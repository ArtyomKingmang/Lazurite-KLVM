# Документация
* [Вывод в консоль. Первая программа](#Вывод-в-консоль)
* [Типы данных](#Типы-данных)
* [Переменные](#Переменные)
* [Консольный ввод](#Консольный-ввод)
* [Конвертация типов](#Конвертация-типов)
* [Логический тип данных](#Логический-тип-данных)
* [Операции сравнения](#Операции-сравнения)
* [Логические-операторы](#Логические-операторы)
* [Условные-конструкции](#Условные-конструкции)
* [Сопоставление с шаблоном](#match-case)
* [Циклы](#Циклы)
* [Строковые шаблоны](#Строковые-шаблоны)
* [Массивы](#Массивы)
* [Функции](#Функции)
* [Ассоциативные массивы](#Ассоциативные-массивы)
* [Анонимные функции](#Анонимные-функции)
* [Битовые сдвиги](#Битовые-сдвиги)
* [Тернарный оператор](#Тернарный-оператор)
* [Библиотеки](#Библиотеки)
* [Подключение файлов .lzr](#Подключение-файлов-lzr)
* [Подключение внешних jar-библиотек](#Подключение-внешних-jar-библиотек)
* [Подключение java библиотек](#Подключение-java-библиотек)
* [ООП](#ООП)
* [Магические методы](#Магические-методы)
* [Ссылки на методы](#Ссылки-на-методы)
* [Расширение оператора "присвоение"](#Расширение-оператора-присвоение)
* [Обработка исключений](#Обработка-исключений)
* [Генерация исключений](#Генерация-исключений)
* [Препроцессор](#Препроцессор)
* [Макросы](#Макросы)
* [Перегрузка операторов](#Перегрузка-операторов)
* [Перечисления](#Перечисления)
* [Assertion](#Assertion)
* [Стандартные функции](#Стандартные-функции)



# Вывод в консоль
Самое просто что можно написать - это Hello World.
Обычно именно с этой программы начинается путь любого программиста.
В Lazurite вывести текст можно вывести *2* методами - `print()` и `println()`.
Второй, в отличие от первого, после вывода строки в консоль отсутпает на следующую строку.
Давайте рассмотрим пример:
```python
println("Hello World!")
```

Вот что мы увидим в консоли: `Hello world!`
Возникает вопрос, куда же делись кавычки? Тут всё просто, если нам нужно сказать компьютеру что далее идёт обычный текст, а не ключевое слово то мы должны писать кавычки без этого работать не будет! Также можно вывести и число, для чисел кавычки не нужны.



# Типы данных
В lazurite из-за динамической типизации не нужно явно объявлять типы, однако
при необходимости это можно сделать.
```java
x = 10 // Number
y = 12.3 // Number
z = "Loren Ipsum" // String (строка)
```

В данном примере у нас как x, так и y являются числом, однако у этого типа
есть еще подтипы:

`byte`: Целочисленный тип данных, хранит значения от -128 до 127.

`short`: Целочисленный тип данных, хранит значения от -32,768 до 32,767. 

`int`: Целочисленный тип данных, хранит значения от -2,147,483,648 до 2,147,483,647.

`long`: Целочисленный тип данных, хранит значения от -9,223,372,036,854,775,808 до 9,223,372,036,854,775,807.

`float`: Тип данных с плавающей запятой одинарной точности, хранит десятичные числа.

`double`: Тип данных с плавающей запятой двойной точности, хранит десятичные числа с большей точностью, чем float.

Что бы указать один из этих типов нужно написать первую букву названия
этого самого типа:

```python
a = 100b
b = 200l
c = 300.587d
d = 400.5f
e = 500i 
f = 600s
```

Также существует удобная форма записи для больших чисел
через нижнее подчеркивание.

Пример:
```kotlin
num1 = 1_000_000
num2 = 200_000

// Вывод: 1200000
println(num1 + num2)
```


Если какая-либо функция предполагает использование строк в качестве аргументов, а были переданы числа, то значения автоматически приведутся к строке.
### Типы Lazurite:
* целое число (int)
* дробное число (float)
* строка (str)

### А также существуют сложные типы:
* массив
* функция
* класс


# Переменные
В прошлом разделе мы говорили про типы данных, так вот их основным способом применения является создание переменных.
Для создания переменных используется конструкция:
`имя = значение`<br>
Переменным можно присваивать любые имена, но есть несколько правил:

1) Делайте имена логичными, чтобы не запутаться
2) Не создавайте несколько переменных с одним именем
   Но кроме их создания их нужно и использовать, тут всё просто, в нужное место пишете имя переменное и её значение подберётся автоматически.

```python
name = "Artyom"
println("Hello " + name)
```
В консоль получим: `Hello Artyom`


# Консольный ввод
Для получения информации от пользователя в консоли нужно использовать метод `readln()`
```python
name = readln("")
println("your name: " + name)
```
Этот код запрашивает у пользователя ввод и записывает его в переменную `name`, а затем выводит сообщение "your name: " и имя пользователя, которое было введено.



# Конвертация типов
Конвертация типов используется для преобразования одного типа данных к другому. Например у вас есть вот такой код:
```python
num1 = "5"
num2 = 5
print(num1 + num2)
```
При запуске такого кода мы получим ошибку, так как мы помним, что `""` характерный признак типа данных "string", который никак не является числом и не может быть прибавлен к числу 5, однако если изменить код так, то все будет работать и в консоль мы получим 10:

```python
num1 = "5"
num2 = 5

print(int(num1) + num2)
```
Все функции: 

`str(value)` - преобразует значение в тип str

`byte(value)` - преобразует значение в тип byte

`double(value)` - преобразует значение в тип double

`float(value)` - преобразует значение в тип float

`int(value) `- преобразует значение в тип int

`long(value) `- преобразует значение в тип long

`num(value)` - преобразует значение в число, если это возможно

`char(value)` - преобразует значение
в символ, если это возможно



# Логический тип данных
В Lazurite нет типа данных bool, он был заменён целыми числами:<br>
все числа *кроме 0* это **правда**, а *0* это **ложь**.

```java
isTrue = 0

// Вывод: false
if (isTrue) {
    print("true")
} else {
    print("false")
}
```

Также в Lazurite есть `true` и `false`, однако это не ключевые слова, а переменные, создаваемые перед началом программы, которые даже можно изменить.

```java
// Рабочий код, который не вызовет ошибку и выведет: false is true
true = 0
false = 1

if (false) {
    print("false is true")
}
```

`true` по умолчанию равен *1*.

`false` по умолчанию равен *0*.



# Операции сравнения

Возвращает true, если оба операнда равны:
`x == y (равно)`

Возвращает true, если оба операнда не равны:
`x != y (не равно)`

Возвращает true, если первый операнд больше второго:
`x > y (больше)`

Возвращает true, если первый операнд меньше второго:
`x < y (меньше)`

Возвращает true, если первый операнд больше или равен второму:
`x <= y (больше или равно)`

Возвращает true, если первый операнд меньше или равен второму:
`x >= y (меньше или равно)`



# Логические операторы

Возвращает true, если x и y возвращают true:
`x and y`; `x && y`

Возвращает true, если x или y возвращает true:
`x or y`; `x || y`

Инвертирует значение x:
`not x`; `!x`



# Условные конструкции
Условия проверяют что-либо, и если это верно, то выполняют какой-либо код.

Простое условие состоит из одного `if`.

```java
if (true) {
    print("true")
}
```

Все условные операторы:

* `if` - *если...*
* `else if` - *в другом случае, если...*
* `else` - *если ни одно из прошлых условий не выполнилось...*

```java
x = 10
if (false) {
    print(1)

} else if (x == 1) {
    print(2)

} else if (x == 10) {
    print(3)

} else {
    print(4)
}
```

Вышеуказанный код выведет 3.
Первое условие не выполниться, потому-что оно false.
Второе условие не выполниться, так как x не равен 1.
Третье условие *выполнится*, так как x равен 10.
else не выполниться, так как было выполнено третье условие.



# match-case
Конструкция *match-case* позволяет сравнить некоторое выражение с набором значений.

```java
x = "str"

match(x) {
    case "": {
        println("Empty")
    }
    case "str": {
        println("Fill")
    }
}
```

### Что происходит?

В *match* как аргумент входит некоторое значение, в данном случае `x`.
Затем это значение сравнивается со всеми *case*.
В данном случае будет выполнен блок кода *case "str"*, так как *`x` равен "str"*,
поэтому в консоль выводиться Fill.

*match-case*, как и функции, умеют возвращать значения:
```java
x = "str"

y = match(x) {
    case "": { return "Empty" }
    case "str": { return "Fill" }
}

// Вывод: Fill
print(y)
```

И также, как и у функций, здесь доступна краткая запись:
```java
x = "two"

// Вывод: Two
print(match(x) {
    case "one": "One"
    case "two": "Two"
    case 1: "One (number)"
    case false: "False"
})
```



# Циклы
Циклы производят выполнение выражений при выполнении условия.

Пример цикла `while`:
```java
while (true) {
  println("Бесконечность не предел!")
}
```
В данном примере мы будем бесконечно выводить *Бесконечность не предел!*, т.к. вместо условия стоит `true`.

* Первый пример цикла `for`:
```java
for (i = 1, i < 10, i++) {
  print(i)
}
```

В данном примере:<br>
Определяем переменную `i` равную *1*<br>
Пока `i` будет меньше *10*:<br>
> Выводим переменную `i`;<br>
> Инкриминируем переменную `i`.

* Второй пример цикла `for`:
```java
arr = Array(3)

arr[0] = 12
arr[1] = 21
arr[2] = 33

for (num : arr) {
  print(num)
}
```

В данном примере мы перебираем все элементы массива `arr` и выводим их предварительно присвоив переменной `num`.



# Строковые шаблоны

Строковые шаблоны - способ вставки значений переменных или выражений непосредственно в строки без необходимости явного конкатенирования или использования сложных операций форматирования.

Примеры использования:
```java
a = 14
b = 88

// Вывод: ab = 1488
print("ab = $a$b")
```

```java
speed = 202
name = "Никита"

// Вывод: Никита, ваша скорость: 202км/ч, пожалуйста, будьте осторожнее.
print("${name}, ваша скорость: ${speed}км/ч, пожалуйста, будьте осторожнее.")
```

```java
for (i = 1, i < 10, i++) {
    println("i = ${i}.")
}

// Вывод:
// i = 1.
// i = 2.
// i = 3.
// i = 4.
// i = 5.
// i = 6.
// i = 7.
// i = 8.
// i = 9.
```



# Массивы
### Это один из сложных типов данных, в нём мы можем хранить сразу несколько значений.
#### Создание массива с указанием количества элементов
```java
array = Array(5)
print(array[1])
```
Первый элемент массива стоит по индексу *0*, так что если мы хотим вывести элемент массива с индексом *1*, то он будет вторым по порядку.
Однако в коде мы создаем массив с *5* ячейками, а значит он выглядит так: `[0, 0, 0, 0, 0]`. Поэтому при выводе `array[1]` мы получим *0*,
так же как было бы с любым другим элементом массива.

#### Создание массива с помощью []
```java
numbers = [1, 2, 3, 4, 5]
```

### Многомерные массивы
Это массивы, которые содержит другие массивы внутри себя.

```java
array = [[1, 1.1, 1.2, 1.3], 2, 3, 4, 5]

// Вывод: 1.1
print(array[0][1])
```

### Функции массивов

В этой части я хочу затронуть функции
массивов, а также показать разные интересные
вещи, которые с ними можно делать.

`array.length` - возвращает размер массива

Пример:
```java
array = [1, 2, 6, 8]
print(array.length)
```
В данном случае в консоль будет выведено 4.

Объединить массив:
```java
array = [3, 5, 7, 9]
array2 = ["Hello", "Example"]

array3 = array << array2
print(array3)
```

В консоль будет выведено:
`[3, 5, 7, 9, Hello, Example]`

Для добавления элемента в массив существует несколько способов. 

* Первый:
```
array = [0, 3, 6, 9]
array += 12

print(array)
```

* Второй:
```java
array = [0, 3, 6, 9]
array = array :: 12

print(array)
```

В обоих случаях в консоль получим:<br>
`[0, 3, 6, 9, 12]`



# Функции
Для определения функции используется ключевое слово `func`. Затем идёт имя, аргументы (если они есть) и тело функции. Пример:


```java
func x(arg) {
  return arg + 10
}
```

Также присутствует сокращенная форма записи функций:

```java
func x(arg) = arg + 10
```

[Анонимные функции](#Анонимные-функции) - особый вид функций, который не имеет имён.
Обычно анонимные функции используются для передачи в другие функции.
Пример анонимной функции:

```java
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]

// Вывод: [1, 3, 5, 7, 9]
print(filter(arr, func(arg) { return arg % 2 }))
```



# Ассоциативные массивы

Ассоциативный массив - это структура данных, которая хранит пары ключ-значение. 
> В отличие от обычного массива, где доступ к элементам осуществляется по индексу, в ассоциативном массиве доступ к элементам осуществляется по ключу. 

Каждый элемент в ассоциативном массиве представляет собой пару, состоящую из *уникального ключа* и соответствующего ему *значения*.

Например, если у нас есть ассоциативный массив, где ключами являются имена студентов, а значениями - их оценки по математике, то мы можем быстро найти оценку конкретного студента, обратившись к ассоциативному массиву по имени студента.

Пример ассоциативного массива:

````java
students = {
   "Alice": 90,
   "Bob": 85,
   "Charlie": 95
}

// Вывод: 85
print(students.Bob)
````
Здесь *Alice*, *Bob* и *Charlie* - это ключи, а *90*, *85* и *95* - соответствующие значения.<br>
Таким образом, если мы обратимся к ассоциативному массиву по ключу *Bob*, мы получим значение *85*.

Однако данная форма обращения к
элементу справедлива только тогда,
когда мы работаем с простыми именами 
ключей.

Допустим у нас есть такой код:

```java
petrol = {
   "Toyota-Mark-2": 95,
   "Mercedes-Benz W140": 95,
}

print(petrol.Toyota-Mark-2)
```
Если мы запустим код, то получим 
ошибку: `VariableDoesNotExistsException`

Связано это со сложным именем ключа. 
Чтобы избегать таких ошибок нужно использовать
другое обращение к ключу:

```java
petrol = {
   "Toyota-Mark-2": 95,
   "Mercedes-Benz W140": 95,
}

print(petrol["Toyota-Mark-2"])
```

Ключи ассоциативного массива так же могут
хранить в себе функции:

```
operation = {
    "plus" : func(a, b) = a + b,
    "minus" : func(a, b) = a - b
}

// Результат: 8
print(operation.plus(2,6))
```



# Анонимные функции
Анонимные функции имеют все те же возможности, что и обычные.
Так, например, можно использовать сокращённый вариант функций:

```java
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]

// Вывод: [1, 2, 4, 5, 7, 8]
print(filter(arr, func(arg) = arg % 3))
```

Анонимные функции можно сохранять в переменных:
```java
func1 = func(x) = x * x - x
```



# Битовые сдвиги

`>>` - сдвигает n бит числа вправо<br>
`>>>` - сдвигает n бит числа вправо, переносит последний бит в начало<br>
`<<` - сдвигает n бит числа влево

Примеры битового сдвига:
```java
print(1 << 10) // 1024
print(4096 >> 10) // 4
print(2147483647) // 1073741823
```



# Тернарный оператор
Пример использования:
```java
a = true
b = false

println(a ? "yes" : "no")
println(b ? "yes" : "no")
```



# Библиотеки
Изначальных возможностей Lazurite может быть недостаточно,
однако эту проблему могут решить встроенные библиотеки.

Импорт библиотек, поставляемых вместе с Lazurite происходит с помощью ключевого слова `using`.

```java
// Пример #1
using "lzr.utils.random"

print(random(1, 100))
```

```java
// Пример #2
using "lzr.utils.math"

print(math.sqrt(121))
```
Более подробно о методах библиотек можно почитать в соответствующих главах



# Подключение файлов .lzr
Что бы воспользоваться функциями
из другого файла .lzr используется 
ключевое слово `using`, а затем указывается путь к файлу. Пример использования:

* Файл `writer.lzr`:
```cpp
func write(arg) {
   print(arg)
}
```

---

* Файл `main.lzr`:
```cpp
using "writer.lzr"

write("Hello World")
```

Подобным образом создаются пользовательские библиотеки
на самом Lazurite.



# Подключение внешних jar библиотек

Что бы подключить стороннюю библиотеку используется
конструкция: `using "name::com.kingmang.lib.Main"`

`name` - имя jar библиотеки, которая должна находится 
в папке *lzrlibs*.

`com.kingmang.lib.Main` - путь к файлу, который является основным в 
библиотеке. Если ваш основной файл называется *invoker*, то его можно не писать.

Пример:
```cpp
using "lzrlgl::com.monsler.lzrlgl"

// GLFW initialization
if (!glfw.init()) {
    print("Error initializing glfw")
}
```
Для примера была взята библиотека [lzrlgl](https://github.com/Monsler/lzrlgl) для работы с openGl.



# Подключение java библиотек

С недавней версии стала доступна директива препроцессора `#jInclude`,
которая позволяет подключать java библиотеки без использования *reflection*.

Пример:
```cpp
#jInclude "java.util.Stack"

stack = new Stack()
stack.push(8)
stack.push(9)

println(stack.pop())
```



# ООП
#### Lazurite - объектно-ориентированный язык программирования, поэтому в нём можно создавать и использовать классы.

Для создания класса используется ключевое слово `class`.
```java
class Man {
    func say(arg) {
        print(arg)
    }
}
```

Для создания экземпляра класса используется ключевое слово `new`.

```java
man = new Man()

// Вывод: hello
man.say("hello")
```

Метод класса с таким же именем, как у класса является конструктором класса, и будет вызван во время создания экземпляра класса.

```java
class Car {
    func Car() {
        print("car created!")
    }
}

// Вывод: car created!
bmw = new Car()
```
Ключевое слово `this` позволяет работать с экземпляром класса.

```java
class Car {
    func Car(brand) {
        this.brand = brand
    }
}

lexus = new Car("lexus")

// Вывод: lexus
print(lexus.brand)
```



# Магические методы
Для классов существует ряд особых, *магических методов*. Это специальные методы,
с помощью которых вы можете добавить "магию" в ваши классы.

* Например, есть `__get__` и `__set__`. Они вызываются при обращении к атрибутам:
```java
class ArrayWrapper {
    func ArrayWrapper(array) {
        this.array = array
    }

    func __get__(key) {
        if (typeof(key) == type.number) {
            return this.array[key]
        } else {
            return getAttr(this, key)
        }
    }

    func __set__(key, value) {
        if (typeof(key) == type.number) {
            this.array[key] = value
        } else {
            setAttr(this, key, value)
        }
    }
}

array = ArrayWrapeer([10, 100, 1000])

// Вывод: 1000
print(array[2])
```
Обратите внимание, что, попытка получить или установить свойство в __get__ и __set__
через `this` напрямую приведёт к *бесконечной рекурсии, а значит, к ошибке*.<br>
Поэтому используются функции `getAttr` и `setAttr`.
Они позволяют установить свойство "напрямую", однако игнорируют
пользовательские методы `__get__` и `__set__`.


```java
class Example {
    func Example(number) {
        this.number = number
    }
    
    
    func __string__() {
        return str(this.number)
    }
}

number = new Example(54)
print(number)
```

Вы заметили, что в классе выше присутствует магический метод `__string__`?
В данном случае он нужен для вывода, так как в `print` всё преобразуется к строке.
А какие есть ещё магические методы для преобразования типов?

| Тип данных | Магический метод |
|:----------:|:----------------:|
|   `str`    |   `__string__`   |
|   `char`   |    `__char__`    |
|            |                  |
|   `num`    |   `__number__`   |
|            |                  |
|   `byte`   |    `__byte__`    |
|  `short`   |   `__short__`    |
|   `int`    |    `__int__`     |
|   `long`   |    `__long__`    |
|            |                  |
|  `float`   |   `__float__`    |
|  `double`  |   `__double__`   |

Ещё есть 3 магических метода для обычных функций:

|  Функция   | Магический метод |
|:----------:|:----------------:|
|  `length`  |   `__length__`   |
| `getBytes` |   `__bytes__`    |
|   `bool`   |    `__bool__`    |

Напомним, что типа данных bool **не существует**,
а эта функция скорее проверяет значение на не пустоту.



# Ссылки на методы
При помощи оператора `::` мы можем получить ссылку на функцию в памяти.
Используется, когда нам нужно получить не результат функции, а сам её объект.

Пример:
```java
func test() {
    return 42
}

// Вывод: func() return 42
print(::test) 
```



# Расширение оператора "присвоение"
Пример использования оператора:
```java
print(x = 10)
```



# Обработка исключений

Для обработки исключений 
используется конструкция
`try catch`. В блок `try`
помещается код, в котором,
вероятно, может быть ошибка.
Блок `catch` вступает в силу,
если при выполнении `try` возникла
ошибка.

Пример:
```java
try {
    print(a)
} catch {
    print("Variable does not exist")
}
```

В консоли мы получим: `Variable does not exist`.
Связано это с тем, что мы не 
создали переменную *a*, которую
хотим вывести в консоль в блоке 
`try`.

Также мы можем получить
конкретный тип ошибки и текст.
Для этого мы можем воспользоваться
полями:
`exception.type`, `exception.text`.

Пример:
```java
try {
    print(a)
} catch if exception.type == "VariableDoesNotExistsException" {
    print(exception.text)
}
```
В консоль мы получим: `Variable: "a" does not exists`



# Генерация исключений
Lazurite позволяет генерировать 
исключения вручную с помощью 
оператора `throw`. 

Пример использования:
```java
try {
    print(a)
} catch {
    throw MyFirstException "Test"
}
```

В данном примере генерируется исключение
с типом `MyFirstException` и 
текстом `Test`. Разумеется использовать
ключевое слово `throw` можно не только
в блоке `try catch`. Достаточно просто
написать:
```cpp
throw MyFirstException "Test"
```

# Препроцессор

Чтобы заработал препроцессор
при запуске интерпретатора лазурита
нужно указать специальный
флаг: *-pr*

`java -jar Lazurite.jar
-pr "test.lzr"` - запуск jar файла

#### Директивы препроцессора:

`#define`- Директива приводит 
интерпретатору заменить 
строку маркера для каждого
вхождения идентификатора в 
исходном файле. Идентификатор 
заменяется только в том случае,
если он формирует маркер

Пример:
```java
#define PI 3.14

// Вывод: 19.7192
print(PI * PI * 2)
```

Добавим немного JavaScript?
```java
#define function func
#define alert print

function main() {
    alert("hello world")
}

main()
```

Или старого Lazurite?
```java
#define void func
#define output print
#define start {
#define stop }

void mul(x, y) start
    return x * y
stop

output(mul(3, 5))
```



# Макросы

Помимо `#define` в Lazurite есть
еще один способ работы с макросами.
Для этого есть ключевое слово `macro`

`macro` - определение макро-функции

Синтаксис:
```cpp
print(res())

macro res() {
    return 4 + 6
}
```



# Перегрузка операторов
Перегрузка операторов позволяет определять новое поведение для стандартных операторов в контексте пользовательских типов данных.
Пример перегрузки операторов в Lazurite:
```java
using "lzr.utils.math"

func `**`(v1, v2) = math.pow(v1, v2)

// Вывод: 729
print(9 ** 3)
```
Таким образом мы определили новое поведение для оператора `**`, взяв из библиотеки *math* функцию `pow` для возведения числа в степень


# Перечисления
Кроме отдельных примитивных типов данных и классов в Lazurite есть 
такой тип как enum или перечисление. 
Перечисления представляют набор логически связанных констант. 
Объявление перечисления происходит с помощью оператора `enum`, 
после которого идет название перечисления. Затем идет список 
элементов перечисления через запятую:

````java
enum Day{
 
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
````

Пример использования:
````java
enum TokenType{
    PLUS,
    MINUS,
    NUMBER
}

class Token{

    func Token(type, text){
        this.type = type
        this.text = text
    }

    func __string__(){
        return "Token: ${this.type}, ${this.text}"
    }
}

token = new Token(TokenType.NUMBER, "123")
println(token)
````

# Assertion

`assert` - ключевое слово для проверки утверждений. 

Сначала указывается ключевое слово `assert`, затем пишется выражение 
или вызывается метод, результатом которого будет булево выражение 
(`true` или `false`)

Пример:
```kotlin
for (i = 0, i < 20, i++) {
    println("i = $i")
    assert i < 10
}
```

В данном примере после вывода `i = 10` будет получена ошибка `Assertion failed: i < 10`.

В итоговых программах `assert` не используется, а нужен он для тестов.



# Стандартные функции

`equals` - сравнивает 2 объекта между собой
```java
print(equals(10, 4)) // 0 (то есть false)
print(equals(10, 10)) // 1 (то есть true)
```

`echo(arg...)` - выводит все переданные значения в консоль, разделяя их пробелом, а потом ставит перенос строки. Может принимать переменное значение аргументов
```java
// Вывод: 1 Hello 3 5 2
echo(1, "Hello", 3, 5, 2) 
```

`length(x)` - возвращает длину строки, размер массива/объекта или количество аргументов функции в зависимости от типа аргумента `x`
```java
x = [1, 4, 6, 4, 4]

print(length(x)) // 5
```

`getBytes(input, charset = "UTF-8")` - возвращает массив байт строки в заданной кодировке
```java
st = "Hello everyone"

// [72, 101, 108, 108, 111, 32, 101, 118, 101, 114, 121, 111, 110, 101]
print(getBytes(st))
```

`sprintf(format, args...)` - форматирует строку

```java
using "lzrx.awt.colors"

println(sprintf(color.red))
print("Hello")
```

`range(from = 0, to, step = 1)` - создаёт массив с элементами числового промежутка. 
```java
println(range(3)) // [0, 1, 2]

r = range(-5, 0) // [-5, -4, -3, -2, -1]
println(r[0]) // -5
```

`substring(str, startIndex, endIndex = ..)`- обрезает строку `str`, начиная от символа после позиции `startIndex` и по `endIndex`. Если `endIndex` не указан, обрезается до конца строки
```java
println(substring("Artyom", 1)) // rtyom
```

`foreach(data, consumer)` - для каждого элемента в массиве или объекте data вызывает функцию consumer
```java
names = ["Artyom", "Nikita", "Gleb"]

// foreach in array
foreach(names, func(i) {
    print(i + ", ")
})
```

`parseInt(str, radix)` - парсит строку в целое число с указанным основанием

`parseLong(str, radix)` - парсит строку в длинное целое число с указанным основанием


`split(str, separator)` - разделяет строку на подстроки на основе указанного разделителя и возвращает массив подстрок.
````java
println(split("Hello, World!", ", ")) // ["Hello", "World!"]
````

`filter(data, predicate)` - фильтрует массив или объект и возвращает массив только с теми элементами, которые удовлетворяют предикату predicate.

```java
users = [
    {"name": "Frank", "money": 1234.56},
    {"name": "Alice", "money": 7890.12},
    {"name": "David", "money": 3456.78}
]

// Выводит список всех людей, у которых более 2000 денег
print(
    filter(
        users,
        func(user) = user.money > 2000
    )
)
```