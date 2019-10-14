# -*- coding: utf-8 -*-
"""Pyspark - Databricks Community Edition.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1UjNgbcOB6u_z8saIcxxvjMrMry2SRP0a

Pour la doc :
https://spark.apache.org/docs/2.2.0/api/python/pyspark.html

Normallement commancer par instancier un spark context. 
conf = SparkConf().setAppName(appName).setMaster(master)
sc = SparkContext(conf=conf)

#### Création d'un RDD contenant des nombres de 0 à 499. Notez bien le type d'objet manipulé (RDD -> Distribué)
"""

data = list(range(0, 500))
distData = sc.parallelize(data)

"""#### Affichage du contenu et de la taille"""

# Afficher le contenu (les 5 premières lignes)
print(distData.take(5)) #ou on peut utiliser collect pour print tout le RDD

# Afficher la taille
print(distData.count())

"""#### Afficher le nombre de partition du RDD (le réduire à 2 puis le mettre à 4)"""

# Afficher le nbr de partitions
print(distData.getNumPartitions())

# Reduce to 2 partitions
rdd2 = distData.coalesce(2)
print(rdd2.getNumPartitions())

# Increase to 4 partitions
rdd4 = rdd2.repartition(4)
print(rdd4.getNumPartitions())

"""### Quelle est la difference entre coalesce et repartition ?

-> Coalesce uses existing partitions to minimize the amount of data that's shuffled. 

-> Repartition creates new partitions and does a full shuffle. 

Coalesce results in partitions with different amounts of data (sometimes partitions that have much different sizes) and repartition results in roughly equal sized partitions.

**Is coalesce or repartition faster?**

coalesce may run faster than repartition, but unequal sized partitions are generally slower to work with than equal sized partitions. You'll usually need to repartition datasets after filtering a large data set. I've found repartition to be faster overall because Spark is built to work with equal sized partitions.

source : https://stackoverflow.com/questions/31610971/spark-repartition-vs-coalesce

#### Récupérer un échantillon de données (disons 100 données, prises au hasard)
"""

# Deux méthodes : une plus exacte mais exige que l'échantillon soit petit
# L'autre plus aléatoire mais supporte une très grande taille pour l'échantillon
print(len(range_rdd.takeSample(True, 100))) 
print(range_rdd.sample(True, 0.2).count())

"""Difference entre les deux méthodes?

-> takesample = Prend nbr en fonction d'un tirage aléatoire d'index (mais necessite d'avoir tout les éléments sur lesquels faire le tirage, du coup fonctionne que sur les petits échantillons, car mets tout dans la mémoire du driver, donc pas distribué, pas big data)

-> sample = big data, pour chaqu'un des nombres, fait un tirage de type bernouilli ou poisson (avec la proba qu'on lui donne qui correspondant à la proba que la pièce tombe sur 1; par example 2/5)

### Quelle est la différence entre Take et TakeOrdered ? 



The take action returns an array of the first n elements (not ordered) whereas takeOrdered returns an array with the first n elements after a sort
"""

print(rdd4.takeOrdered(100))

"""#### Différence entre Map et FlatMap ?

Flatmap : Return a new RDD by first applying a function to all elements of this RDD, and then flattening the results
"""

# Map example
print(sc.parallelize(range(1000)).map(lambda x: 2 * x).take(10))

# Flatmap example
lines = sc.parallelize("coucou")
print(lines.flatMap(lambda line: line.split(' ')).collect())

"""#### Enregistrer votre RDD dans HDFS (au format csv)"""

df.rdd.saveAsTextFile("df2.csv")

"""#### Liser le fichier enregistré précédemment (avec spark.sparkContext.textFile ET avec spark.sparkContext.wholeTextFiles). Quelle est la différence entre ces deux primitives ?"""

# With TextFile
lines = sc.textFile("df2.csv")
print(lines.take(5))

print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")

# With whole textFiles
lines2 = sc.wholeTextFiles("df2.csv")
print(lines2.take(5))