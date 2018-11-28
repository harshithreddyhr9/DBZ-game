from flask import Flask,request,Response
from flask_restful import Resource, Api
import json
import sys

app = Flask(__name__)
api = Api(app)
board = {'foo' : 20,'bar': 30,"john": 26,"harshith": 28}

class Game(Resource):

	def get(self):
		return Response(response=json.dumps(board),status=200)

	def post(self):
		user_name = request.json['username']
		score = request.json['score']
		board[user_name] = score
		return Response(status=201)

api.add_resource(Game,"/scoreboard")

def start_server(port):
	try:
		app.run(debug=True,host= '0.0.0.0',port=port)
	except:
		print("handling error")

if __name__ == '__main__':
	port = sys.argv[1]
	start_server(port)