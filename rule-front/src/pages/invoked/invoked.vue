<!--<template>-->
  <!--<div class="dashboard-container">-->
    <!--<el-tabs type="border-card" style="height:826px;padding 0">-->
      <!--<el-tab-pane>-->
        <!--<span slot="label">-->
          <!--<i class="el-icon-setting"></i> 数据质量检测-->
        <!--</span>-->
        <!--<el-row :gutter="1">-->
          <!--<el-col :span="6">-->
            <!--<div class="cutline" style="height:785px;border-right: 2px dashed #eee;  ">-->
              <!--<el-row style="width:100%;height:68px;border-bottom: 1px solid #eee; ">-->
                <!--<el-input-->
                  <!--placeholder="请输入内容"-->
                  <!--clearable-->
                  <!--style="width:40%;margin-top:22px;margin-left:12px"-->
                  <!--size="small"-->
                  <!--v-model="filterText"-->
                <!--&gt;</el-input>-->
                <!--&lt;!&ndash; <el-button size="small" @click="Method">-->
                  <!--保存目录-->
                <!--</el-button> &ndash;&gt;-->
              <!--</el-row>-->
              <!--<div>-->
                <!--<el-tree-->
                  <!--class="filter-tree"-->
                  <!--:data="data2"-->
                  <!--:props="defaultProps"-->
                  <!--default-expand-all-->
                  <!--@node-click="handleNodeClick2"-->
                  <!--:filter-node-method="filterNode"-->
                  <!--style="margin-left:15px"-->
                  <!--ref="tree"-->
                  <!--:expand-on-click-node="false"-->
                  <!--show-checkbox-->
                <!--&gt;-->
                <!---->
                  <!--<span class="custom-tree-node" slot-scope="{ node, data }">-->
                    <!--<span>{{ node.label }}</span>-->
                    <!--<span>-->
                      <!--<el-button-->
                        <!--v-if="  node.label == '正则匹配检测'"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="openDialog(data)"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-circle-plus-outline"></i>-->
                      <!--</el-button>-->

                      <!--<el-button-->
                        <!--v-if="node.parent.label == '正则匹配检测'"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="treeSetting(data)"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-setting"></i>-->
                      <!--</el-button>-->
                      <!---->
                      <!--<el-button-->
                        <!--v-if="node.parent.label == '正则匹配检测'"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color :#000"-->
                        <!--@click="verifyDel(node,data)"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-delete"></i>-->
                      <!--</el-button>-->
                    <!--</span>-->
                  <!--</span>-->
                <!--</el-tree>-->
              <!--</div>-->
            <!--</div>-->
          <!--</el-col>-->
          <!--<el-col :span="18">-->
            <!--<div class="cutline" style="height:785px;">-->
              <!--<el-row style="width:100%;height:28px;margin-top:12px;margin-left:8px ;">-->

                <!--<div style="float:left;border-radius: 4px;">-->
                  <!--<el-tag type="success">{{currentCategory || '全部检测'}}模块</el-tag>-->
                <!--</div>-->

                <!--<div style="float:left;border-radius: 4px;">-->
                  <!--<el-tag type="info">规则总数：{{currentTotalRule}}</el-tag>-->
                <!--</div>-->


                <!--<div style="float:right;margin-right: 2% ;">-->
                  <!--<el-button-->
                  <!--@click="centerDialogVisible1 = true ; fieldForm.col=null; fieldForm.name=null; fieldForm.classType=null"-->
                  <!--size="small"-->
                  <!--icon="el-icon-circle-plus-outline"-->
                <!--&gt;新增</el-button>-->
                <!--</div>-->
                <!---->
                <!---->

                <!--<div style="float:right;margin-right: 2% ;width:38%">-->
                  <!--<el-input  size="small" placeholder="模糊匹配" v-model="input3" >-->
                    <!--<el-button  size="small" type="primary" plain slot="append" icon="el-icon-search"></el-button>-->
                  <!--</el-input>-->
                <!--</div>-->
              <!--</el-row>-->
              <!--<el-row-->
                <!--class="cardrow"-->
                <!--style="margin-top:2%; margin-left:2% ; height:660px ;overflow-y: scroll;"-->
              <!--&gt;-->
                <!--<el-col :span="6" v-for="(o, index) in tableData2" :key="o" style="padding:12px">-->
                  <!--<el-card shadow="always" :body-style="{ padding: '0px' }">-->
                    <!--<div slot="header" class="clearfix">-->
                      <!--&lt;!&ndash; <svg-icon icon-class="dashboard" class='icon' /> &ndash;&gt;-->
                      <!--<el-tag type="info" style="text-overflow:ellipsis">{{o.name}}</el-tag>-->
                      <!--<el-button-->
                        <!--style="float: right; padding: 3px 0;color:red"-->
                        <!--type="text"-->
                        <!--@click="delUnnatural(index,o.id)"-->
                      <!--&gt;删除</el-button>-->
                    <!--</div>-->
                    <!--<div style="padding: 6px;">-->
                      <!--<div style="font-size:8px;margin-top:6px">-->
                        <!--<el-button disabled type="text">作用于：</el-button>-->
                        <!--<span>{{o.tableName}}表</span>-->
                      <!--</div>-->
                      <!--<div style="font-size:8px;margin-top:6px">-->
                        <!--<el-button disabled type="text">规则类型：</el-button>-->
                        <!--<span type="text">{{o.effect}}</span>-->
                      <!--</div>-->
                      <!--<el-divider></el-divider>-->
                      <!--<div class="bottom clearfix">-->
                        <!--<time class="time">{{ o.time }}</time>-->
                        <!--<el-button-->
                          <!--style="cursor:pointer;"-->
                          <!--type="text"-->
                          <!--class="button"-->
                          <!--@click="fire(o) ;RsdialogVisible=true"-->
                        <!--&gt;执行</el-button>-->
                      <!--</div>-->
                    <!--</div>-->
                  <!--</el-card>-->
                <!--</el-col>-->
              <!--</el-row>-->
            <!--</div>-->
          <!--</el-col>-->
        <!--</el-row>-->
      <!--</el-tab-pane>-->
    <!--</el-tabs>-->

    <!--<el-dialog :title="calculateTitle?calculateTitle : '未选择检测模块'" :visible.sync="centerDialogVisible1" width="30%" center>-->
      <!--<el-dialog width="30%" :visible.sync="innerVisible" append-to-body>-->
        <!--<el-form>-->
          <!--<el-form-item label="数据集">-->
            <!--<el-select v-model="pojo" filterable placeholder="请选择数据集" style="width:60%">-->
              <!--<el-option-->
                <!--v-for="item in pojoSet"-->
                <!--:key="item.value"-->
                <!--:label="item.label"-->
                <!--:value="item"-->
              <!--&gt;</el-option>-->
            <!--</el-select>-->
          <!--</el-form-item>-->
        <!--</el-form>-->
        <!--<span slot="footer" class="dialog-footer">-->
          <!--<el-button type="primary" @click="closeInnerDialog(pojo)">确 定</el-button>-->
          <!--<el-button @click="innerVisible = false">取 消</el-button>-->
        <!--</span>-->
      <!--</el-dialog>-->

      <!--<el-form-->
        <!--ref="fieldForm"-->
        <!--:model="fieldForm"-->
        <!--label-width="120px"-->
        <!--size="small"-->
        <!--:rules="rules"-->
        <!--:label-position="labelPosition"-->
      <!--&gt;-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="methodForm.alias"></el-input>-->
        <!--</el-form-item>-->

        <!--<el-form-item label="说明">-->
          <!--&lt;!&ndash; <el-select-->
            <!--v-model="currentMethodId"-->
            <!--placeholder="请选择方法"-->
            <!--style="width:100%"-->
            <!--@change="readMethod"-->
          <!--&gt;-->
            <!--<el-option-->
              <!--v-for="type in methodSet"-->
              <!--:label="type.label"-->
              <!--:value="type.value"-->
              <!--:key="type.label"-->
            <!--&gt;</el-option>-->
          <!--</el-select> &ndash;&gt;-->
          <!--<el-collapse-->
            <!--v-model="activeNames"-->
            <!--@change="handleChange"-->
            <!--style="margin-top:-8px"-->
          <!--&gt;-->
            <!--<el-collapse-item title="*******" name="1">-->
              <!--<div>作用：{{currentDes.effect }}</div>-->
              <!--<div>参数：{{currentDes.arguments }}</div>-->
              <!--<div>返回：{{currentDes.callback }}</div>-->
            <!--</el-collapse-item>-->
          <!--</el-collapse>-->
        <!--</el-form-item>-->
        <!--<el-form-item  v-for="(it,$index) in args" :label="it.label">-->
          <!--<el-row v-if="!it.select">-->
            <!--<el-input :disabled="it.type=='regex' " v-model.number="it.values" :type="it.type" :placeholder="it.placeholder"></el-input>-->
          <!--</el-row>-->
          <!--<el-row v-else>-->
            <!--<el-select-->
              <!--v-if="it.linkDataset.id"-->
              <!--v-model="it.values"-->
              <!--:multiple="it.multiple"-->
              <!--collapse-tags-->
              <!--filterable -->
              <!--:placeholder="it.placeholder"-->
              <!--style="width:60%"-->
            <!--&gt;-->
              <!--<el-option-->
                <!--v-for="el in it.pojoElements"-->
                <!--:label="el.label"-->
                <!--:value="el.value"-->
                <!--:key="el.label"-->
              <!--&gt;</el-option>-->
            <!--</el-select>-->
            <!--<el-input-->
              <!--:disabled="logicType=='isNull'"-->
              <!--style="width:60%"-->
              <!--v-else-->
              <!--v-model="it.values"-->
              <!--:placeholder="it.placeholder"-->
            <!--&gt;</el-input>-->
            <!--<el-button-->
              <!--@click="openInnerDialog(it);it.pojoElements.length=0"-->
              <!--plain-->
              <!--style="float : right ;width:40%"-->
              <!--size="small"-->
              <!--type="primary"-->
            <!--&gt;{{it.linkDataset.label}}</el-button>-->
          <!--</el-row>-->
          <!--<el-select v-model="logicType" v-if="$index==0 && logic" style="width:60%">-->
            <!--<el-option v-for="val in logic " :label="val.label" :value="val.value" :key="val.label"></el-option>-->
          <!--</el-select>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveMethod">确 定</el-button>-->
        <!--<el-button @click="centerDialogVisible1 = false ; showDescription = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog-->
      <!--:title="widCount"-->
      <!--:visible.sync="RsdialogVisible"-->
      <!--width="60% ;height:668px"-->
      <!--:before-close="handleClose"-->
    <!--&gt;-->
      <!--<div-->
        <!--v-loading="loading"-->
        <!--element-loading-text="计算中"-->
        <!--element-loading-spinner="el-icon-loading"-->
        <!--class="wids"-->
        <!--style=" overflow-y: scroll;  width:100%;height:320px;border: 1px solid #eee;box-shadow: 0 1px 12px 0 rgba(0, 0, 0, 0.1)"-->
      <!--&gt;-->
        <!--<el-tag-->
          <!--v-for="item in wids"-->
          <!--:key="item"-->
          <!--type="danger"-->
          <!--effect="dark"-->
          <!--style="margin: 12px 12px"-->
        <!--&gt;{{ item }}</el-tag>-->
      <!--</div>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button @click="RsdialogVisible = false">取 消</el-button>-->
        <!--<el-button type="primary" @click="RsdialogVisible = false">确 定</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog title="添加层级" :visible.sync="centerDialogVisible" width="30%" center>-->
      <!--<el-form ref="form" label-width="80px" size="small" :label-position="labelPosition">-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="currentCategory"></el-input>-->
        <!--</el-form-item>-->

        <!--<el-form-item>-->
          <!--<el-input v-show="false" v-model="treeData"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="append(treeData)">确 定</el-button>-->
        <!--<el-button @click="centerDialogVisible = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->

    <!--<el-dialog title="设置层级正则表达式" :visible.sync="RegexDialogVisible" width="30%" center>-->
      <!--<el-form ref="form" label-width="120px" size="small" :label-position="labelPosition">-->
        <!--<el-form-item label="表达式选择">-->
          <!--<el-input v-model="currentRegex"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<el-form-item>-->
          <!--<el-input v-show="false" v-model="currentNode"></el-input>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<span slot="footer" class="dialog-footer">-->
        <!--<el-button type="primary" @click="saveRegex">确 定</el-button>-->
        <!--<el-button @click="RegexDialogVisible = false">取 消</el-button>-->
      <!--</span>-->
    <!--</el-dialog>-->
  <!--</div>-->
<!--</template>-->

<!--<script>-->
<!--import {-->
  <!--resultSave,-->
  <!--getResultCategoryList,-->
  <!--getResultByCategory,-->
  <!--delResult-->
<!--} from "@/api/resultset";-->
<!--import {-->
  <!--supportSave,-->
  <!--getSupportCategory,-->
  <!--getSupportById-->
<!--} from "@/api/datasupport";-->
<!--import { getColumns, readPojoById, getCategoryList } from "@/api/pojoset";-->
<!--import {-->
  <!--save,-->
  <!--getCalculateByCategory,-->
  <!--del,-->
  <!--fireById,-->
  <!--categoryList,-->
  <!--getQualityAll-->
<!--} from "@/api/calculate";-->
<!--import { format } from "@/utils/dateformat";-->
<!--import FileSaver from "file-saver";-->
<!--import { debuglog } from "util";-->
<!--import { insertMethod ,getMethod2All ,updateMethod,delMethodByName} from '@/api/Methods'-->

<!--export default {-->
  <!--// TODO: draggable container  scroll , endEvent\startEvent-css end\starter-event-function-->

  <!--watch: {-->
    <!--filterText(val) {-->
      <!--this.$refs.tree.filter(val);-->
    <!--},-->
    <!--centerDialogVisible1: function(newVal, oldVal) {-->
      <!--if (newVal) {-->
        <!---->
        <!--this.methodForm.name = null;-->
      <!--}-->
    <!--},-->
    <!--currentMethodId: function(newVal,oldVal){-->
      <!--if(newVal!==oldVal){-->
      <!--this.showDescription = true;-->
      <!--this.currentDes = JSON.parse(-->
        <!--JSON.stringify(this.methodDescritions[newVal - 1])-->
      <!--);-->
      <!--this.args = this.currentDes.args;-->
      <!--this.args.forEach(element => {-->
        <!--if(element.type=='regex'){-->
          <!--element.values = this.currentRegex-->
        <!--}-->
      <!--});-->
      <!--this.logic = this.currentDes.logic;-->
      <!--}-->
    <!--}-->
  <!--},-->
  <!--methods: {-->

    <!--getMethod2AllInit(){-->
      <!--// this.data2[1].children.length=0-->
      <!--getMethod2All().then((response)=>{-->
      <!--response.data.forEach(el => {-->
        <!--this.data2[1].children.push(el)-->
      <!--});-->
    <!--})-->
    <!--},-->
    <!---->

    <!--saveRegex(){-->
      <!--this.args.forEach(element => {-->
        <!--if(element.type=='regex'){-->
          <!--element.values = this.currentRegex-->
        <!--}-->
      <!--});-->
      <!--this.RegexDialogVisible=false-->
      <!--let params = {}-->
      <!--params.name=this.currentNode.label-->
      <!--params.id = this.currentNode.methodId-->
      <!--params.parentId = '2'-->
      <!--params.data = {regex:this.currentRegex}-->
      <!--params.data = JSON.stringify(params.data)-->
      <!--params.qualityType = this.currentNode.qualityType-->
      <!--updateMethod(params).then((response)=>{-->
        <!--alert(response.data)-->
        <!--this.data2[1].children.length=0-->
        <!--this.getMethod2AllInit()-->
      <!--})-->
    <!--},-->

    <!--treeSetting(data){-->
      <!--let config  = JSON.parse(data.data)-->
      <!--this.currentRegex = config.regex-->
      <!--this.RegexDialogVisible=true-->
      <!--this.currentNode = data-->
    <!--},-->

    <!--verifyDel(node, data) {-->
      <!--this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {-->
        <!--confirmButtonText: "确定",-->
        <!--cancelButtonText: "取消",-->
        <!--type: "warning"-->
      <!--})-->
        <!--.then(() => {-->
          <!--this.$message({-->
            <!--type: "success",-->
            <!--message: "删除成功!"-->
          <!--});-->
          <!--delMethodByName(data.label).then(() => {-->
            <!--const parent = node.parent;-->
            <!--const children = parent.data.children || parent.data;-->
            <!--const index = children.findIndex(d => d.id === data.id);-->
            <!--children.splice(index, 1);-->
          <!--});-->
        <!--})-->
        <!--.catch(() => {-->
          <!--this.$message({-->
            <!--type: "info",-->
            <!--message: "已取消删除"-->
          <!--});-->
        <!--});-->
    <!--},-->

    <!--openInnerDialog(it) {-->
      <!---->
      <!--this.pojo = null;-->
      <!--this.currentIt = it;-->
      <!--this.innerVisible = true;-->
      <!---->
    <!--},-->

    <!--closeInnerDialog(pojo) {-->
      <!--this.currentIt.linkDataset.id = pojo.value;-->
      <!--this.currentIt.linkDataset.label = pojo.label;-->
      <!--readPojoById(this.currentIt.linkDataset.id).then(response => {-->
        <!--this.pojoElements.length = 0;-->
        <!--let config = JSON.parse(response.data.data);-->
        <!--config.forEach(element => {-->
          <!--let a = {-->
            <!--label: element.alias,-->
            <!--value: element.getter,-->
            <!--cg: "cgBean." + element.getter-->
          <!--};-->
          <!--this.currentIt.pojoElements.push(a);-->
        <!--});-->
        <!--this.innerVisible = false;-->
      <!--});-->
    <!--},-->

    <!--fire(o) {-->
      <!--this.wids.length = 0;-->
      <!--this.widCount = null;-->
      <!--this.loading = true;-->
      <!--let ruleJson = {};-->
      <!--ruleJson.MVELExpression = [];-->
      <!--ruleJson.MVELExpression.push({-->
        <!--name: o.name,-->
        <!--description: "质量检测",-->
        <!--priority: 1,-->
        <!--condition: "1==1",-->
        <!--action: "DataSupport.setInterimMap(" + o.mvel + ");"-->
      <!--});-->
      <!--let params = { id: o.id };-->
      <!--fireById(params).then(response => {-->
        <!--if (response.data.length > 501) {-->
          <!--for (let i = 0; i < 501; i++) {-->
            <!--this.wids.push(response.data[i]);-->
          <!--}-->
        <!--} else {-->
          <!--this.wids = response.data;-->
        <!--}-->
        <!--this.widCount = "WID共计条数：" + response.data.length;-->
        <!--this.loading = false;-->
      <!--});-->
    <!--},-->

    <!--updateCalculate(id) {-->
      <!--this.currentDes = this.tableData2[id].Des;-->
      <!--this.centerDialogVisible1 = true;-->
    <!--},-->
    <!--openDialog(data) {-->
      <!--this.centerDialogVisible = true;-->
      <!--this.currentCategory=null-->
      <!--this.treeData = data;-->
    <!--},-->
    <!--saveMethod() {-->
      <!--//let mvel = this.currentDes.mvel+-->
      <!--//TODO: 组装mvel，确定参数的位置，循环参数，mvel拼接，对于这种字段类型的参数必须升级为变量参数。变成字符串形式。升级为变量参数-->
      <!--let params = [];-->
      <!--this.currentDes.args.forEach((element, index) => {-->
        <!--switch (element.type) {-->
          <!--case "number":-->
            <!--if (index == this.currentDes.args.length - 1) {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel + element.values + ")";-->
            <!--} else {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel + element.values + "),";-->
            <!--}-->
            <!--break;-->
          <!--case "String":-->
            <!--if (index == this.currentDes.args.length - 1) {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel + "'" + element.values + "'" + ")";-->
            <!--} else {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel + "'" + element.values + "'" + "),";-->
            <!--}-->
            <!--break;-->
          <!--case "HashSet":-->
            <!--if (index == this.currentDes.args.length - 1) {-->
              <!--//这里固定了第一个参数-->
            <!--} else {-->
              <!--let strList = "[";-->
              <!--element.values.forEach(el => {-->
                <!--strList = strList + "'" + el + "'" + ",";-->
              <!--});-->
              <!--strList = strList.substring(0, strList.length - 1);-->
              <!--strList = strList + "]";-->
              <!--this.currentDes.mvel = this.currentDes.mvel + strList + ",";-->
            <!--}-->
            <!--break;-->
          <!--case "regex":-->
            <!--this.currentDes.regex = element.values;-->
          <!--default:-->
            <!--break;-->
          <!--case "calculate":-->
            <!--if (index == this.currentDes.args.length - 1) {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel +-->
                <!--"'" +-->
                <!--element.values +-->
                <!--"'," +-->
                <!--"'" +-->
                <!--this.logicType +-->
                <!--"')";-->
            <!--} else {-->
              <!--this.currentDes.mvel =-->
                <!--this.currentDes.mvel + "'" + element.values + "'" + ",";-->
            <!--}-->
            <!--break;-->
        <!--}-->

        <!--// }-->
      <!--});-->
      <!--// this.tableData2.push({name:this.methodForm.name})-->
      <!--// this.currentDes.pojo=this.pojo-->
      <!--let pojos = [];-->
      <!--this.currentDes.args.forEach(value => {-->
        <!--if (value.linkDataset && value.linkDataset.id !== null) {-->
          <!--pojos.push({-->
            <!--label: value.linkDataset.label,-->
            <!--value: value.linkDataset.id,-->
            <!--dataName: value.linkDataset.dataName-->
          <!--});-->
        <!--}-->
      <!--});-->
      <!--this.currentDes.params = params;-->
      <!--let qualityConfig = {-->
        <!--mvel: this.currentDes.mvel,-->
        <!--pojo: pojos,-->
        <!--effect: this.currentDes.effect,-->
        <!--regex: this.currentDes.regex ? this.currentDes.regex : ""-->
      <!--};-->
      <!--let datas = {-->
        <!--userId: "1",-->
        <!--data: {-->
          <!--name: this.methodForm.alias,-->
          <!--category: this.currentCategory,-->
          <!--time: new Date().format("yyyy-MM-dd hh:mm:ss"),-->
          <!--config: qualityConfig-->
        <!--}-->
      <!--};-->
      <!--save(datas).then(() => {-->
        <!--this.tableData2.length = 0;-->
        <!--getCalculateByCategory(this.currentCategory)-->
          <!--.then(response => {-->
            <!--response.data.forEach(element => {-->
              <!--let config = JSON.parse(element.data);-->
              <!--let tableName = [];-->
              <!--if (config.pojo instanceof Array) {-->
                <!--config.pojo.forEach(el => {-->
                  <!--tableName.push(el.label);-->
                <!--});-->
              <!--} else {-->
                <!--tableName = config.pojo.label;-->
              <!--}-->
              <!--this.tableData2.push({-->
                <!--name: element.name,-->
                <!--time: element.time,-->
                <!--id: element.id,-->
                <!--pojo: config.pojo,-->
                <!--effect: config.effect,-->
                <!--mvel: config.mvel,-->
                <!--regex: config.regex,-->
                <!--tableName: JSON.stringify(tableName)-->
              <!--});-->
            <!--});-->
            <!--this.centerDialogVisible1 = false;-->
          <!--})-->
          <!--.catch(() => {});-->
      <!--});-->
    <!--},-->
    <!--readMethod(value) {-->
      <!--this.showDescription = true;-->
      <!--this.currentDes = JSON.parse(-->
        <!--JSON.stringify(this.methodDescritions[value - 1])-->
      <!--);-->
      <!--this.args = this.currentDes.args;-->
      <!--this.logic = this.currentDes.logic;-->
      <!--//这里的currentDes 需要进行深度拷贝，形成一个一个实例，用户列表展示，最终也是一个一个计算方法的实例对象。-->
    <!--},-->
    <!--delUnnatural(index, id) {-->
      <!--this.tableData2.splice(index, 1);-->
      <!--del(id).then(() => {});-->
    <!--},-->
    <!--open(node, data) {-->
      <!--this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {-->
        <!--confirmButtonText: "确定",-->
        <!--cancelButtonText: "取消",-->
        <!--type: "warning"-->
      <!--})-->
        <!--.then(() => {-->
          <!--this.$message({-->
            <!--type: "success",-->
            <!--message: "删除成功!"-->
          <!--});-->
          <!--this.remove(node, data);-->
        <!--})-->
        <!--.catch(() => {-->
          <!--this.$message({-->
            <!--type: "info",-->
            <!--message: "已取消删除"-->
          <!--});-->
        <!--});-->
    <!--},-->

    <!--filterNode(value, data) {-->
      <!--if (!value) return true;-->
      <!--return data.label.indexOf(value) !== -1;-->
    <!--},-->
    <!--append(data) {-->

      <!--let params = {}-->
      <!--params.name=this.currentCategory-->
      <!--params.id = data.methodId-->
      <!--params.parentId = '2'-->
      <!--params.data = {regex:this.currentRegex}-->
      <!--params.data = JSON.stringify(params.data)-->
      <!--params.qualityType = data.qualityType-->
      <!--insertMethod(params).then((response)=>{-->
          <!--alert(response.data)-->
      <!--})-->
      <!--let dataC = {regex:null}-->
      <!--const newChild = {-->
        <!--id: 0,-->
        <!--label: this.currentCategory,-->
        <!--methodId:2,-->
        <!--qualityType:'准确性',-->
        <!--data:JSON.stringify(dataC),-->
        <!--children: []-->
      <!--};-->
      <!--if (!data.children) {-->
        <!--this.$set(data, "children", []);-->
      <!--}-->
      <!--data.children.push(newChild);-->
      <!--this.centerDialogVisible = false;-->
    <!--},-->

    <!--remove(node, data) {-->
      <!--const parent = node.parent;-->
      <!--const children = parent.data.children || parent.data;-->
      <!--const index = children.findIndex(d => d.id === data.id);-->
      <!--children.splice(index, 1);-->
    <!--},-->
    <!--//tree 2-->
    <!--handleNodeClick2(data, node) {-->
      <!--let arrays = [];-->
      <!--if(!this.centerDialogVisible){-->
        <!--this.currentCategory = data.label;-->
        <!--this.calculateTitle = '《'+data.label+'》' + "方法实例化";-->
      <!--}-->
      <!--this.currentMethodId=data.methodId-->
      <!--if(data.data){-->
        <!--debugger-->
        <!--let dataConfig  = JSON.parse(data.data)-->
        <!--this.currentRegex = dataConfig.regex-->
      <!--}-->
      <!---->
      <!--this.tableData2.length = 0;-->
      <!--getCalculateByCategory(data.label)-->
        <!--.then(response => {-->
          <!--response.data.forEach(element => {-->
            <!--let config = JSON.parse(element.data);-->
            <!--let tableName = [];-->
            <!--if (config.pojo instanceof Array) {-->
              <!--config.pojo.forEach(el => {-->
                <!--tableName.push(el.label);-->
              <!--});-->
            <!--} else {-->
              <!--tableName = config.pojo.label;-->
            <!--}-->
            <!--this.tableData2.push({-->
              <!--name: element.name,-->
              <!--time: element.time,-->
              <!--id: element.id,-->
              <!--pojo: config.pojo,-->
              <!--mvel: config.mvel,-->
              <!--effect: config.effect,-->
              <!--regex: config.regex,-->
              <!--tableName: JSON.stringify(tableName)-->
            <!--});-->
          <!--});-->
          <!--this.currentTotalRule= this.tableData2.length-->
        <!--})-->
        <!--.catch(() => {});-->
    <!--},-->

    <!--getParentLabel2(arrays, node) {-->
      <!--arrays.push(node.label);-->
      <!--if (node.parent != null) {-->
        <!--this.getParentLabel(arrays, node.parent);-->
      <!--} else {-->
        <!--return arrays;-->
      <!--}-->
    <!--},-->
    <!--supportCategoryInit() {-->
      <!--categoryList("1").then(response => {-->
        <!--this.data2[0].children = [];-->
        <!--response.data.forEach(element => {-->
          <!--this.data2[0].children.push({ id: 0, label: element });-->
        <!--});-->
      <!--});-->
    <!--}-->
  <!--},-->
  <!--data() {-->
    <!--return {-->
      <!--currentTotalRule:null,-->
      <!--currentNode:null,-->
      <!--currentRegex:null,-->
      <!--RegexDialogVisible:false,-->
      <!--currentMethodId:null,-->
      <!--logic: null,-->
      <!--logicType: null,-->
      <!--currentIt: null,-->
      <!--treeData: null,-->
      <!--loading: true,-->
      <!--widCount: null,-->
      <!--wids: [],-->
      <!--RsdialogVisible: false,-->
      <!--calculateTitle: null,-->
      <!--currentTime: null,-->
      <!--currentCategory: null,-->
      <!--activeNames: "1",-->
      <!--pojo: {-->
        <!--label: null,-->
        <!--value: null-->
      <!--},-->
      <!--pojoSet: [],-->
      <!--pojoElements: [],-->
      <!--args: null,-->
      <!--methodForm: {-->
        <!--name: null,-->
        <!--singleArg: null,-->
        <!--arrayArg: null-->
      <!--},-->
      <!--currentDes: {-->
        <!--effect:null,-->
        <!--arguments:null,-->
        <!--callback:null-->
      <!--},-->
      <!--showDescription: false,-->
      <!--methodSet: [-->
        <!--{-->
          <!--label: "多字段重复",-->
          <!--value: 1-->
        <!--},-->
        <!--{-->
          <!--label: "正则表达式",-->
          <!--value: 2-->
        <!--},-->
        <!--{-->
          <!--label: "常规计算",-->
          <!--value: 3-->
        <!--}-->
      <!--],-->
      <!--methodDescritions: [-->
        <!--{-->
          <!--name: "1",-->
          <!--effect: "找出数据集中重复的数据。",-->
          <!--arguments: "1.需要计算的一个或多个字段，2.出现重复的次数。",-->
          <!--callback: "返回重复的数据",-->
          <!--mvel:-->
            <!--"matchProvider.excludeByMultipleFieldMap(DataSupport.getOriginData,",-->
          <!--args: [-->
            <!--{-->
              <!--label: "数据库字段",-->
              <!--type: "HashSet",-->
              <!--placeholder: "先关联数据集，再选择字段",-->
              <!--select: true,-->
              <!--multiple: true,-->
              <!--switchValue: true,-->
              <!--values: [],-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--label: "重复次数",-->
              <!--type: "number",-->
              <!--placeholder: "重复次数",-->
              <!--select: false,-->
              <!--switchValue: null,-->
              <!--values: 0-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "2",-->
          <!--effect: "找出与正则表达式不匹配的数据",-->
          <!--arguments: "1.需要计算的字段， 2.正则表达式",-->
          <!--callback: "返回不符合的数据",-->
          <!--mvel:-->
            <!--"matchProvider.regex(DataSupport.getOriginData,DataSupport.regex,",-->
          <!--regex: null,-->
          <!--args: [-->
            <!--{-->
              <!--label: "正则表达式",-->
              <!--type: "regex",-->
              <!--placeholder: "输入或选择正则表达式",-->
              <!--select: false,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: ""-->
            <!--},-->
            <!--{-->
              <!--label: "数据库字段",-->
              <!--type: "String",-->
              <!--placeholder: "校验字段",-->
              <!--select: true,-->
              <!--multiple: false,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "cgBean.",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--},-->
        <!--{-->
          <!--name: "3",-->
          <!--effect: "常规计算：判空、相等、包括",-->
          <!--arguments: "1.比较者， 2.被比较者",-->
          <!--callback: "返回不符合的数据",-->
          <!--mvel:-->
            <!--"matchProvider.calculate(DataSupport.getOriginData,DataSupport.getCompareData,",-->
          <!--logic: [-->
            <!--{-->
              <!--value: "equals",-->
              <!--label: "等于"-->
            <!--},-->
            <!--{-->
              <!--value: "isNull",-->
              <!--label: "判空"-->
            <!--},-->
            <!--{-->
              <!--value: "include",-->
              <!--label: "不被包含于"-->
            <!--}-->
          <!--],-->
          <!--args: [-->
            <!--{-->
              <!--label: "参数一",-->
              <!--type: "calculate",-->
              <!--placeholder: "比较者",-->
              <!--select: true,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "originData"-->
              <!--},-->

              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--label: "参数二",-->
              <!--type: "calculate",-->
              <!--placeholder: "被比较者",-->
              <!--select: true,-->
              <!--switchValue: null,-->
              <!--values: null,-->
              <!--elValue: "",-->
              <!--linkDataset: {-->
                <!--id: null,-->
                <!--label: "@关联数据集",-->
                <!--dataName: "compareData"-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--]-->
        <!--}-->
      <!--],-->
      <!--rules: {-->
        <!--col: [{ required: true, message: "请输入字段", trigger: "blur" }],-->
        <!--classType: [-->
          <!--{ required: true, message: "请选择字段类型", trigger: "change" }-->
        <!--]-->
      <!--},-->
      <!--newTreeNode: {-->
        <!--label: ""-->
      <!--},-->
      <!--value: [],-->
      <!--labelPosition: "left",-->
      <!--fieldForm: {-->
        <!--name: null,-->
        <!--classType: null,-->
        <!--col: null,-->
        <!--status: false,-->
        <!--natural: false,-->
        <!--annotation: null-->
      <!--},-->
      <!--centerDialogVisible1: false,-->
      <!--centerDialogVisible2: false,-->
      <!--centerDialogVisible: false,-->
      <!--innerVisible: false,-->
      <!--tableData: [],-->
      <!--tableData2: [],-->
      <!--filterText: "",-->
      <!--data2: [-->
        <!--{-->
          <!--id: 1,-->
          <!--label: "数据重复检测",-->
          <!--methodId: 1,-->
          <!--qualityType:'唯一性',-->
          <!--children: []-->
        <!--},{-->
          <!--id: 2,-->
          <!--methodId: 2,-->
          <!--label: "正则匹配检测",-->
          <!--qualityType:'准确性',-->
          <!--children: []-->
        <!--},{-->
          <!--id: 3,-->
          <!--label: "空值检测",-->
          <!--methodId: 3,-->
          <!--qualityType:'空值',-->
          <!--children: []-->
        <!--},{-->
          <!--id: 4,-->
          <!--label: "数据与参照值对比检测",-->
          <!--methodId: 4,-->
          <!--qualityType:'正确性',-->
          <!--children: []-->
        <!--}-->
      <!--],-->
      <!--defaultProps: {-->
        <!--children: "children",-->
        <!--label: "label"-->
      <!--}-->
    <!--};-->
  <!--},-->
  <!--computed: {-->
    <!--upperComputed: {-->
      <!--get: function() {-->
        <!--return this.fieldForm.col;-->
      <!--},-->
      <!--set: function(val) {-->
        <!--if (this.tableData.length === 0) {-->
          <!--this.fieldForm.col = val.toUpperCase();-->
        <!--} else {-->
          <!--this.tableData.some((value, index) => {-->
            <!--if (value.col === val.toUpperCase()) {-->
              <!--this.fieldForm.col = "字段已经存在";-->
              <!--return true;-->
            <!--} else {-->
              <!--this.fieldForm.col = val.toUpperCase();-->
            <!--}-->
          <!--});-->
        <!--}-->
      <!--}-->
    <!--}-->
  <!--},-->
  <!--mounted: function() {-->
    <!--// this.resultCategoryInit()-->
    <!--// this.supportCategoryInit();-->

    <!--getQualityAll().then((response)=>{-->
      <!--response.data.forEach(element => {-->
            <!--let config = JSON.parse(element.data);-->
            <!--let tableName = [];-->
            <!--if (config.pojo instanceof Array) {-->
              <!--config.pojo.forEach(el => {-->
                <!--tableName.push(el.label);-->
              <!--});-->
            <!--} else {-->
              <!--tableName = config.pojo.label;-->
            <!--}-->
            <!--this.tableData2.push({-->
              <!--name: element.name,-->
              <!--time: element.time,-->
              <!--id: element.id,-->
              <!--pojo: config.pojo,-->
              <!--mvel: config.mvel,-->
              <!--effect: config.effect,-->
              <!--regex: config.regex,-->
              <!--tableName: JSON.stringify(tableName)-->
            <!--});-->
          <!--});-->
          <!--this.currentTotalRule= this.tableData2.length-->
    <!--})-->

    <!--getCategoryList("1").then(response => {-->
      <!--response.data.forEach(element => {-->
        <!--if(element.id!==0){-->
          <!--let a = { label: element.name, value: element.id };-->
          <!--this.pojoSet.push(a);-->
        <!--}-->
      <!--});-->
    <!--});-->
    <!--this.getMethod2AllInit()-->

  <!--}-->
<!--};-->
<!--</script>-->

<!--<style lang="scss" >-->
<!--.board-column-content {-->
  <!--height: auto;-->
  <!--overflow: hidden;-->
  <!--border: 10px solid transparent;-->
  <!--min-height: 60px;-->
  <!--display: flex;-->
  <!--justify-content: flex-start;-->
  <!--flex-direction: column;-->
  <!--align-items: center;-->
<!--}-->
<!--.el-table .warning-row {-->
  <!--background: oldlace;-->
<!--}-->

<!--.el-table .success-row {-->
  <!--background: #f0f9eb;-->
<!--}-->

<!--// .el-tabs__item {-->
<!--//   padding: 20px;-->
<!--// }-->

<!--.dashboard {-->
  <!--&-container {-->
    <!--margin: 30px;-->
    <!--height: 826px;-->
  <!--}-->
  <!--&-text {-->
    <!--font-size: 30px;-->
    <!--line-height: 46px;-->
  <!--}-->
<!--}-->
<!--.el-header {-->
  <!--background-color: #b3c0d1;-->
  <!--color: #333;-->
  <!--line-height: 60px;-->
<!--}-->

<!--.el-aside {-->
  <!--color: #333;-->
<!--}-->

<!--.el-row {-->
  <!--margin-bottom: 20px;-->
  <!--&:last-child {-->
    <!--margin-bottom: 0;-->
  <!--}-->
<!--}-->
<!--.el-col {-->
  <!--border-radius: 4px;-->
<!--}-->
<!--.bg-purple-dark {-->
  <!--background: #99a9bf;-->
<!--}-->
<!--.bg-purple {-->
  <!--background: #d3dce6;-->
<!--}-->
<!--.bg-purple-light {-->
  <!--background: #e5e9f2;-->
<!--}-->
<!--.grid-content {-->
  <!--border-radius: 4px;-->
  <!--min-height: 36px;-->
  <!--border-right: 2px dashed #eee;-->
<!--}-->
<!--.row-bg {-->
  <!--padding: 10px 0;-->
  <!--background-color: #f9fafc;-->
<!--}-->

<!--.cutline {-->
  <!--position: relative;-->
  <!--left: -15px;-->
  <!--top: -15px;-->
<!--}-->
<!--.cardrow::-webkit-scrollbar {-->
  <!--display: none;-->
<!--}-->
<!--.wids::-webkit-scrollbar {-->
  <!--display: none;-->
<!--}-->
<!--.textarea {-->
  <!--min-height: 260px;-->
<!--}-->
<!--.board-item {-->
  <!--cursor: pointer;-->
  <!--width: 100%;-->
  <!--height: 32px;-->
  <!--margin: 5px 0;-->
  <!--background-color: #ecf5ff;-->
  <!--text-align: left;-->
  <!--line-height: 28px;-->
  <!--padding: 5px 10px;-->
  <!--box-sizing: border-box;-->
  <!--box-shadow: 0px 1px 3px 0 rgba(0, 0, 0, 0.2);-->
<!--}-->
<!--.custom-tree-node {-->
  <!--flex: 1;-->
  <!--display: flex;-->
  <!--align-items: center;-->
  <!--justify-content: space-between;-->
  <!--font-size: 14px;-->
  <!--padding-right: 8px;-->
<!--}-->

<!--.el-transfer-panel {-->
  <!--max-width: 30%;-->
  <!--height: 580px;-->
<!--}-->
<!--.el-transfer-panel__list.is-filterable::-webkit-scrollbar {-->
  <!--width: 0 !important;-->
<!--}-->
<!--.el-transfer-panel__list.is-filterable {-->
  <!--height: 480px;-->
<!--}-->
<!--.el-table__body-wrapper::-webkit-scrollbar {-->
  <!--width: 0 !important;-->
<!--}-->
<!--.el-transfer-panel .el-transfer-panel__header .el-checkbox .el-checkbox__label {-->
  <!--font-size: 10px;-->
<!--}-->
<!--.time {-->
  <!--font-size: 13px;-->
  <!--color: #999;-->
<!--}-->

<!--.bottom {-->
  <!--margin-top: 13px;-->
  <!--line-height: 12px;-->
<!--}-->

<!--.button {-->
  <!--padding: 0;-->
  <!--float: right;-->
<!--}-->

<!--.image {-->
  <!--width: 100%;-->
  <!--display: block;-->
<!--}-->

<!--.clearfix:before,-->
<!--.clearfix:after {-->
  <!--display: table;-->
  <!--content: "";-->
<!--}-->

<!--.clearfix:after {-->
  <!--clear: both;-->
<!--}-->
<!--</style>-->
