# Task_02_17
(*) Даны три вершины треугольника. Узнать, в каких четвертях (на координатной сетке) он находится. Координаты треугольника ((X1, Y1), (X2, Y2), (X3, Y3)) задаются в произвольном порядке. Учесть, что треугольник вида ((-1, -1), (-1, 5), (5, -1)) лежит сразу в 4-х плоскостях. Распечатать четверти, в которых лежит треугольник, в виде цифр через запятую в порядке от 1 до 4, например, для приведенного выше треугольника вывод будет выглядеть так: 1, 2, 3, 4.

Пояснение алгоритма:
1. Треугольник находится в какой-либо четверти, если его отрезок (line) находится в этой четверти.
2. Отрезок находится в какой-либо четверти, если хотя бы одна из его концевых точек находится в этой четверти, или точки его пересечния с осями координат (x при y = 0, y при x = 0, в итоге получается точка zeroCoordinatesPoint с координатами (xAtZeroY, yAtZeroX)) повзоляют отнести его к какой-либо четверти.
3. Нахождение того, в какой четверти находится точка представялется тривиальным.

Пояснение реализации: 
1. Четверти, в которых лежат отрезки упаковываются в массивы (прямая может лежать максимум в трёх четверятях).
2. Затем треугольник перебирает эти массивы отрезков, записывая в свой массив все встреченные четверти.
3. Возвращение в main, печать с перебором значений массива четвертей треугольника через их ordinal'ы.

Пример работы программы:


![task_2_17](https://user-images.githubusercontent.com/71034843/97307546-e5753680-1870-11eb-87d6-3ef90cb9e196.png)
