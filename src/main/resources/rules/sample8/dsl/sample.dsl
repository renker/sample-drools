[keyword][]等于===
[keyword][]大于=>
[keyword][]小于=<
[condition][]学生的姓名 {operate} {name}=Student(name {operate} {name})
[condition][]学生的年龄 {operate} {age}=Student(age {operate} {age})
[consequence][]学生的成绩 赋值 {value}=Student(score={value})
[condition][]并且=and
[condition][]或者=or
[consequence][]{param1}=System.out.println({param1});