from flask import Flask,request,render_template
from A3 import *
app = Flask(__name__)

@app.route('/')
def mainpage():
    return render_template('index.html',product=None)

@app.route('/eval',methods=['POST','GET'])   #eval is name of page in browser
def multiply():
    z = prod(int(request.form['num1']),int(request.form['num2']))
    #p = b2d(z[:-1])        
    return render_template('index.html',product=z)
if __name__=="__main__":
    app.run()
