# Реализация волнового алгоритма
1. Создаем двумерный массив. Присваиваем элементам по краям массива значение -1.
2. Создаем в середине массива блоки, через которые необходимо пройти. Для этого генерируем N случайных пар координат, и присваиваем этим элементам также значение -1.
3. Начальную и конечную точку сперва можно определить как `[array.length - 2, 1]` и `[1, array.length - 2]`. Элементу `[array.length - 2, 1, 1]` присваиваем значение 1. Элементу `[1, array.length - 2]` - значение - 2, чтобы отличать его от остальных.
4. Первая часть алгоритма заключается в присвоении соседним (справа, слева, снизу, сверху) элементам значение на 1 большее, чем у элемента-родителя. Для этого организовываем цикл по всему массиву, чтобы обнаружить элементы с текущим значением шагов. Элементам-соседям присваиваем значение на единицу больше, если их значение равно 0.
5. Эту процедуру повторяем в цикле. Цикл продолжается пока не найден финишный элемент со значением -2 или не заполнен весь массив (не заменены все 0 на количество шагов).
6. Вторая часть алгоритма заключается в поиске наикратчашего пути. Для этого ищем вокруг финишного элемента значение количества итераций, которое получем из прошлого метода заполнения массива. Каждую итерацию изменяем адрес ячейки и уменьшаем переменную, храняющую количество итераций, необходимых для достижения финишной ячейки. А также записываем в строку эти координаты.
7. Полученная на выходе строка сожержит путь в обратном направлении. Поэтому с помощью `split` получаем массив строк, переворачиваем его, и отобращаем в консоле.

# К доработке
1. Доработать вывод самого поля в консоль. В случае прямоугольной матрицы границы ячеек не рисуются пока.
2. Обработать вариант, когда путь к финишу невозможен. Да данный момент программа вылетает с ошибкой.
3. Написать ввод пользователя размера поля, количества стен.
4. Организовать метод генерирования уникальных индексов для "установки" стен. На данный момент нет гарантии, что будет столько же стен, сколько указано в качестве аргумента в методе.
5. Прописать условие максимального количества стен. Оно не может быть больше, чем количество нулей в исходном массиве.
6. Визуализировать путь на отображаемом заполненном массиве, скажем, обозначив значения элементом другим цветом.
7. Распределить более граммотно методы и всю структуру проекта. Организовать отдельно файл UI и, возможно, раздеить общие методы, специфические для этой задачи методы, и написанные в будущем методы проверок.