import threading
import random
import time
from pymongo import MongoClient

class Philosopher(threading.Thread):
	running=True
	def __init__(self,i,name,forkonleft,forkonright):
		threading.Thread.__init__(self)
		self.index=i		
		self.name=name
		self.forkonleft=forkonleft
		self.forkonright=forkonright
	def run(self):
		while(self.running):
			print "Philosoper %s thinking"%self.name 
			time.sleep(random.uniform(5,15))# thinking
			print "Now %s is hungry"%self.name
			self.dine()
	def dine(self):
		fork1,fork2=self.forkonleft,self.forkonright
		while (self.running):
			fork1.acquire(True)
			locked=fork2.acquire(False)
			if locked:
				break
			fork1.release()
			print "%s swapping forks"%self.name
			fork2,fork1=fork1,fork2
		else:
			return
		self.dining()
		fork1.release()
		fork2.release()

	def dining(self):
		print "%s starts eating "%self.name
#		URI = 'mongodb://username:password@ipaddress:27017/userdb'
#		c = MongoClient(URI)
#		time.sleep(10)
		c=MongoClient('127.0.0.1',27017)
		coll=c.new_cl3_a4.coll1
		data= coll.find({'philosopher_number':self.index})
		for i in data:
			print i
		print "%s finished eating" %self.name

def DiningPhilosopers():
	Forks=[threading.Lock() for i in range(5)]
	PhilosopherNames=('Akhil','Ketul','Shreyas','Pravin','Hrishi')
	Philosophers=[Philosopher(i,PhilosopherNames[i],Forks[i%5],Forks[(i+1)%5]) for i in range(5)]
	random.seed(555)
	Philosopher.running=True
	for p in Philosophers:
		p.start()
	time.sleep(30)
	Philosopher.running=False
	print "running is stopped in main"

DiningPhilosopers()
		
