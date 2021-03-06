from flask import Flask, render_template, request, url_for, jsonify


app = Flask(__name__)

@app.route('/echo', methods=['POST'])
def testPostReqeust():
    #print request headers
    print "request headers="+str(request.headers)
    #request.data - Contains the incoming request data
    print "request.data="+str(request.data)
    #request.form  -A MultiDict with the parsed form data from POST or PUT requests
    print "request.form="+str(request.form)
    #Parses the incoming JSON request data and returns it
    if len(request.data) :
    	return request.data
    else :
        return "EMPTY REQUEST DATA!!"


 
#USE THIS ENDPOINT TO VIEW THE HEALTH OF THE APPLICATION SITTING BEHIND THE SIDECAR, http://${sidecar.host}/8000/health 
@app.route('/health', methods=['GET'])
def testGet():
    status = {"status":"UP"}
    return jsonify(status)

if __name__ == '__main__':
  app.run( host="0.0.0.0", port=int("8000"), debug=True)
