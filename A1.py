import xml.etree.ElementTree as ET
import unittest
        

class bsearch:
    a=[]
    ans=-1

    def __init__(self,xml_file='A1.xml'):
#         length=int(input("Length of array  "))
#         for i in range(length):
#             self.a.append(int(input()))
        tree= ET.parse(xml_file)
        for child in tree.getroot():
            self.a.append(int(child.text))
        print self.a
        self.sort()
        print self.a

	key = int(input("Enter the element to be searched: "))
        #key=int(input())
        self.ans=self.search(key, 0,len(self.a))

    def sort(self):
        self.a.sort()

    def search(self,key,low=0,high=len(a)):        
        mid=(low+high)/2
#         print mid
        if self.a[mid]==key:
            return mid+1
        elif(self.a[mid]<key):
            return self.search(key,mid+1,high)
        else:
            return self.search(key, low, mid-1)
        return -1
b=bsearch()
print b.ans
# 
class mytest(unittest.TestCase):
    def test_postive(self):
        self.assertEqual(b.ans,7)
#        self.assertEqual(obj.tester([10,20,30,40,50],40),4)
    def test_negative(self):
        self.assertNotEqual(b.ans,9)
#        self.assertEqual(obj.tester([10,20,30,40,50],4),0)
unittest.main()
