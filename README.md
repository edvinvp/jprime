

# About JPrIME

JPrIME is a Java library primarily aimed at phylogenetics,
although other functionality may be added over time as well.

The package is developed and maintained by computational biology
groups at [Science for Life Laboratory Stockholm](http://www.scilifelab.se/).
It has its roots in a C++ library named PrIME, primarily developed by PIs
Jens Lagergren, Lars Arvestad, and Bengt Sennblad. The first version was written
by __Joel Sjöstrand__. Other important contributors are:

- Mehmood Alam Khan 
- Raja Hashim Ali
- Ikram Ullah
- Owais Mahmudhi
- Auwn Muhammed
- Vincent Llorens

# Installation

The easiest way to install JPrime is to download the latest [JAR file found in
our Dropbox directory](https://www.dropbox.com/sh/4yfyav5wmeyk34a/AAAhayS-dwx0OBeJl5RpuOYha?dl=0).
This is a single JAR file bundled with all external
dependencies. It will most likely be named 'jprime-X.Y.Z.jar', with
X.Y.Z referring to its current incarnation.

You may place the JAR file anywhere on your computer. However, for frequent use,
you may want to add its location to your CLASSPATH or similarly, as outlined
[on Wikipedia](http://en.wikipedia.org/wiki/Classpath_(Java)).

## Invocation

Straightforward invocation of the JAR file, in this case using the _Delirious_ (DLRS) model:
```
java -jar jprime-X.Y.Z.jar Delirious Host.tree Seqs.fa Gene2Host.txt
```

It can be convenient to create a script with the particular call that you want to use! For example, if 
you want to try different host trees, create a script in a file `dlrs_hosts.sh` (for example) with this contents:
```
#! /bin/bash
JAR=/path/to/jprime-X.Y.Z.jar
java -jar $JAR Delirious $1 Seqs.fa Gene2Host.txt
```
After running `chmod +x dlrs_hosts.sh`, this script can be called like this:
```
./dlrs_hosts.sh hostfile1.tree
```
if `hostfile1.tree` is a Newick host tree that you want to try.



## Hacking
For hacking, the location of the JAR file can be specified explicitly when you
start an application such as in this fictitious example:

```
java -cp ~/mypath/jprime-X.Y.Z.jar se/cbb/jprime/apps/MyApp <args>
```

# Documentation

For instructions on how to run applications, tutorials, source code, etc., please
visit the Wiki pages at JPrIME's home at GitHub.com, https://github.com/arvestad/jprime/wiki.


# Releases and source code

JPrIME is currently hosted at GitHub: https://github.com/arvestad/jprime.

# Frequently Asked Questions

+ How can I sample dated reconciliations ([or _d_-realisations as defined in Mahmudi et al. 2013](http://www.biomedcentral.com/1471-2105/14/S15/S10)) of a gene tree with a species tree using JPrIME-DLRS?

Yes, it is possible to sample realisations using JPrIME-DLRS. Please see the help file for providing arguments by using the following command:
```
java -jar jprime.jar Delirious -h
```

A typical example of running JPrIME while sampling realisations would look like this: (examples files can be downloaded from [here](https://github.com/arvestad/jprime/tree/master/sample_data))
```
java -jar target/jprime-x.y.z.jar Delirious -i 1000 -t 10 -sm WAG -real realisations.txt 1 -o samples.mcmc sample_data/dlrs_example_1.stree.txt sample_data/dlrs_example_1.fa.txt sample_data/dlrs_example_1.map.txt
```
