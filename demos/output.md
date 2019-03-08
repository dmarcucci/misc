Example: plus
-------------
originalList = [b, a, c]

additionalList = [f, e, d]

originalList + additionalList: [b, a, c, f, e, d]

originalList (after) = [b, a, c]

Example: addAll
---------------
originalList = [b, a, c]

additionalList = [f, e, d]

originalList (after originalList.addAll(additionalList)) = [b, a, c, f, e, d]

Example: leftShift
------------------
originalList = [b, a, c]

additionalList = [f, e, d]

originalList (after originalList << additionalList) = [b, a, c, [f, e, d]]

Example: minus
--------------
originalList = [b, a, c]

originalList - 'b': [a, c]

originalList (after) = [b, a, c]

------------------------------------

originalList = [b, a, c]

originalList - ['b', 'c']: [a]

originalList (after) = [b, a, c]

Example: multiply
-----------------
String character = +

int number = 5

------------------------------------

+ * 5: +++++

Example: sort
-------------
originalList = [b, a, c]

originalList.sort(false): [a, b, c]

originalList (after) = [b, a, c]

originalList = [b, a, c]

originalList.sort() / originalList.sort(true): [a, b, c]

originalList (after) = [a, b, c]

------------------------------------

Closure compareIds = { a, b -> a.id <=> b.id }

listOfMaps = [[id:3], [id:2], [id:5], [id:1]]

listOfMaps.sort(false, compareIds): [[id:1], [id:2], [id:3], [id:5]]

listOfMaps (after) = [[id:3], [id:2], [id:5], [id:1]]

listOfMaps = [[id:3], [id:2], [id:5], [id:1]]

listOfMaps.sort(true, compareIds): [[id:1], [id:2], [id:3], [id:5]]

listOfMaps (after) = [[id:1], [id:2], [id:3], [id:5]]

Example: times
--------------
Closure printHelloWorld = { println 'Hello world!' }

int number = 5

number.times(printHelloWorld) / number.times { println 'Hello world!' }:
Hello world!
Hello world!
Hello world!
Hello world!
Hello world!

Example: toBigDecimal
---------------------
int number = 5

number instanceof Integer: true

------------------------------------

number.toBigDecimal(): 5

number.toBigDecimal() instanceof Integer: false

number.toBigDecimal() instanceof BigDecimal: true

Example: toString
-----------------
int number = 5

number instanceof Integer: true

------------------------------------

"$number": 5

"$number" instanceof Integer: false

"$number" instanceof GString: true

Example: with ?
---------------
Integer nullVariable = null

nullVariable?.intValue(): null

Example: without ?
------------------
Integer nullVariable = null

java.lang.NullPointerException: Cannot invoke method intValue() on null object

Example: collect
----------------
originalList = [b, a, c]

originalList.collect { it * 2 }: [bb, aa, cc]

------------------------------------

listOfMaps = [[id:3], [id:2], [id:5], [id:1]]

listOfMaps.collect { it.id }: [3, 2, 5, 1]

Example: collectMany
--------------------
listOfList = [[1, 2], [3, 4], [5, 6]]

listOfList.collectMany { it * 2 }: [1, 2, 1, 2, 3, 4, 3, 4, 5, 6, 5, 6]

Example: collectEntries
-----------------------
map = [a:1, b:2, c:3, d:4, e:5]

map.collectEntries { k, v -> [v, k] }: [1:a, 2:b, 3:c, 4:d, 5:e]

map (after) = [a:1, b:2, c:3, d:4, e:5]

------------------------------------

originalList = [b, a, c]

originalList.collectEntries { [originalList.indexOf(it), it] }: [0:b, 1:a, 2:c]

originalList (after) = [b, a, c]

Example: find
-------------
map = [a:1, b:2, c:3, d:4, e:5]

map.find { k, v -> v % 2 == 0}: b=2

------------------------------------

listOfList = [[1, 2], [3, 4], [5, 6]]

listOfList.find { it.sum() > 5 }: [3, 4]

Example: findAll
----------------
map = [a:1, b:2, c:3, d:4, e:5]

map.findAll { k, v -> v % 2 == 0}: [b:2, d:4]

------------------------------------

listOfList = [[1, 2], [3, 4], [5, 6]]

listOfList.findAll { it.sum() > 5 }: [[3, 4], [5, 6]]

Example: findResults
--------------------
map = [a:1, b:2, c:3, d:4, e:5]

map.findResults { k, v -> if (v % 2 != 0) { v - 2 > 1 ? v * "$v" : null } } }: [ccc, eeeee]

------------------------------------

listOfList = [[1, 2], [3, 4], [5, 6]]

listOfList.findResults { if (it.sum() >= 7) { it.sum() == 11 ? 'eleven' : 'seven' } }: [seven, eleven]

Example: flatten
----------------
listOfList = [[1, 2], [3, 4], [5, 6]]

listOfList.flatten(): [1, 2, 3, 4, 5, 6]

------------------------------------

originalList << additionalList: [b, a, c, [f, e, d]]

(originalList << additionalList).flatten(): [b, a, c, f, e, d]

Example: containsAll
--------------------
originalList = [b, a, c]

originalList.containsAll(['a', 'c']): true

originalList.containsAll(['c', 'd']): false

Example: count
--------------
listWithDuplicates = [a, b, c, d, a, f, g, a, i, j, k, l, a, n, o, d]

listWithDuplicates.count('a'): 4

listWithDuplicates.count('d'): 2

Example: sum
------------
listOfList.flatten(): [1, 2, 3, 4, 5, 6]

listOfList.flatten().sum(): 21

listOfMaps = [[id:3], [id:2], [id:5], [id:1]]

listOfMaps.sum { it.id }: 11

Example: each
-------------
emptyString = ''

map = [a:1, b:2, c:3, d:4, e:5]

map.each { k, v -> emptyString += k * v }: abbcccddddeeeee

Example: eachWithIndex
----------------------
emptyString = ''

map = [a:1, b:2, c:3, d:4, e:5]

map.eachWithIndex { k, v, index -> emptyString += index + (k * v) }: 0a1bb2ccc3dddd4eeeee

Example: groupBy
----------------
listOfIntegers = [1, 2, 3, 4, 5, 6]

listOfIntegers.groupBy { it % 2 }: [1:[1, 3, 5], 0:[2, 4, 6]]

Example: join
-------------
listOfStrings = [a, b, c, d, e, f]

listOfStrings.join(): abcdef

listOfStrings.join(','): a,b,c,d,e,f

Example: split
--------------
listOfStrings.join(','): a,b,c,d,e,f

listOfStrings.join(',').split(','): [a, b, c, d, e, f]

listOfStrings.join(',').split(',') == listOfStrings: true

Example: first
--------------
listOfIntegers = [2, 6, 5, 3, 1, 4]

listOfIntegers.first(): 2

Example: last
-------------
listOfIntegers = [6, 1, 3, 5, 2, 4]

listOfIntegers.last(): 4

Example: max
------------
listOfIntegers = [3, 2, 1, 6, 5, 4]

listOfIntegers.max(): 6

Example: min
------------
listOfIntegers = [3, 2, 6, 4, 1, 5]

listOfIntegers.min(): 1
