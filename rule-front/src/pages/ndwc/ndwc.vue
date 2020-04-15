<!--<template>-->
  <!--<div>-->
    <!--<el-tabs-->
      <!--v-loading="loading"-->
      <!--element-loading-text="计算中"-->
      <!--element-loading-spinner="el-icon-loading"-->
      <!--element-loading-background="rgba(0, 0, 0, 0.8)"-->
      <!--type="border-card"-->
      <!--style="height:826px;padding 0;margin:0"-->
    <!--&gt;-->
      <!--<el-tab-pane>-->
        <!--<span slot="label">-->
          <!--<i class="el-icon-setting"></i> 预警规则-->
        <!--</span>-->
        <!--<el-row :gutter="1">-->
          <!--<el-col :span="4">-->
            <!--<div class="cutline" style="height:785px;border-right: 2px dashed #eee;  ">-->
              <!--<el-row style="width:100%;height:68px;border-bottom: 1px solid #eee; ">-->
                <!--&lt;!&ndash; <el-input-->
                  <!--placeholder="请输入内容"-->
                  <!--clearable-->
                  <!--style="width:60%;margin-top:22px;margin-left:12px"-->
                  <!--size="small"-->
                  <!--v-model="filterText"-->
                <!--&gt;</el-input>&ndash;&gt;-->
                <!--<el-button-->
                  <!--@click="addNode=true;append"-->
                  <!--style="margin-top: 8% ;margin-left:36%"-->
                  <!--size="small"-->
                  <!--class="el-icon-circle-plus-outline"-->
                <!--&gt;新增</el-button>-->
              <!--</el-row>-->
              <!--<div>-->
                <!--<el-tree-->
                  <!--class="filter-tree"-->
                  <!--:data="treeDoms"-->
                  <!--:props="defaultProps"-->
                  <!--default-expand-all-->
                  <!--@node-click="handleNodeClick"-->
                  <!--:filter-node-method="filterNode"-->
                  <!--style="margin-left:15px"-->
                  <!--ref="tree"-->
                  <!--:expand-on-click-node="false"-->
                <!--&gt;-->
                  <!--<span class="custom-tree-node" slot-scope="{ node, data }">-->
                    <!--<span>{{ node.label }}</span>-->
                    <!--<span>-->
                      <!--<el-button-->
                        <!--v-if="data.addKidsBT"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="addTreeDialogVisible = true; newTreeLabel='' "-->
                      <!--&gt;-->
                        <!--<i class="el-icon-circle-plus-outline"></i>-->
                      <!--</el-button>-->

                      <!--<el-button-->
                        <!--v-if="data.editBT"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--style="color : #000"-->
                        <!--@click="RegexDialogVisible = true"-->
                      <!--&gt;-->
                        <!--<i class="el-icon-setting"></i>-->
                      <!--</el-button>-->

                      <!--<el-button-->
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
          <!--<el-col :span="20">-->
            <!--<div style="width:100%;height:760px">-->
              <!--<div style="height:9%;width:100%;">-->
                <!--<el-row :gutter="20" >-->
                  <!--<el-col :span="20">-->
                    <!--&lt;!&ndash; <el-button @click="unfold" size="small">展开全部</el-button>-->
                    <!--<el-button @click="packUpAll" size="small">收起全部</el-button>&ndash;&gt;-->

                    <!--<el-alert style="width:100%" title="规则组说明：" type="info" show-icon :closable="false">规则组由多个规则组成，有添加规则、删除规则、调整规则执行顺序功能，可以为单个规则定义名称、描述。规则数据来源手动选取。规则组将按照规则序号，顺序向下执行。</el-alert>-->
                  <!--</el-col>-->
                  <!--&lt;!&ndash; <el-col style="margin: 0" :span="12"></el-col> &ndash;&gt;-->
                <!--</el-row>-->
              <!--</div>-->
              <!--<div-->
                <!--v-if="ruleSet.length!=0"-->
                <!--class="cutline"-->
                <!--style=" margin-left:1%; margin-top:1%;height:80%;overflow: auto;border: 1px solid #E4E7ED;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)"-->
              <!--&gt;-->
                <!--<div-->
                  <!--v-for="(i,$index) in ruleSet"-->
                  <!--:key="i"-->
                  <!--style="margin:8px;width:98%;border-radius: 4px;border: 1px solid #EBEEF5;"-->
                <!--&gt;-->
                  <!--<div-->
                    <!--ref="ruleTitle"-->
                    <!--v-bind:style="i.ruleColor"-->
                    <!--style="width:100%;height:36px;margin:0"-->
                  <!--&gt;-->
                    <!--<div style="float:left;margin-top:3px">-->
                      <!--<el-button-->
                        <!--disabled-->
                        <!--style="margin:2%"-->
                        <!--type="text"-->
                        <!--size="mini"-->
                        <!--circle-->
                      <!--&gt;{{$index+1}}</el-button>-->
                    <!--</div>-->

                    <!--<el-tooltip :content="i.name" placement="bottom" effect="light">-->
                      <!--<el-input-->
                        <!--:disabled="i.ToBeSource"-->
                        <!--size="mini"-->
                        <!--effect="plain"-->
                        <!--v-model="i.name"-->
                        <!--placeholder="请输入规则名称"-->
                        <!--style="float:left;margin:4px;width:12%"-->
                      <!--&gt;</el-input>-->
                    <!--</el-tooltip>-->

                    <!--<el-tooltip :content="i.desc" placement="bottom" effect="light">-->
                      <!--<el-input-->
                        <!--v-model="i.desc"-->
                        <!--size="mini"-->
                        <!--effect="plain"-->
                        <!--placeholder="请输入规则描述"-->
                        <!--style="margin: 4px;width:30%"-->
                      <!--&gt;</el-input>-->
                    <!--</el-tooltip>-->
                    <!--<el-tag-->
                      <!--v-if="i.ruleType=='single'"-->
                      <!--style="margin-left:2%;widht:20%;cursor: pointer;"-->
                      <!--type="primary"-->
                      <!--size="mini"-->
                      <!--@click="currentRule=i.pojo; dialogSourceVisible = true"-->
                    <!--&gt;{{i.pojo.label}}</el-tag>-->

                    <!--<el-tag-->
                      <!--v-if="i.elapsedTime"-->
                      <!--style="margin-left:2%;widht:20%;"-->
                      <!--type="primary"-->
                      <!--size="mini"-->
                    <!--&gt;{{i.elapsedTime}}</el-tag>-->

                    <!--<el-button-->
                      <!--v-if="!i.ToBeSource"-->
                      <!--size="mini"-->
                      <!--style="float:right;margin:4px;width:8%"-->
                      <!--@click="deleteRule($index)"-->
                    <!--&gt;删除本段</el-button>-->
                    <!--<el-dropdown @command="addRule" style="float:right;margin:4px;width:10%">-->
                      <!--<el-button size="mini" effect="plain" style="width:100%">-->
                        <!--段后追加-->
                        <!--<i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
                      <!--</el-button>-->
                      <!--<el-dropdown-menu slot="dropdown">-->
                        <!--<el-dropdown-item :command="['s',$index]">单数据源规则</el-dropdown-item>-->
                        <!--&lt;!&ndash; <el-dropdown-item :command="['d',$index]">双数据源规则</el-dropdown-item> &ndash;&gt;-->
                      <!--</el-dropdown-menu>-->
                    <!--</el-dropdown>-->
                    <!--<el-button-->
                      <!--v-if="$index!=0 && !i.ToBeSource"-->
                      <!--size="mini"-->
                      <!--style="float:right;margin:4px;width:8%"-->
                      <!--@click="uppWard($index)"-->
                    <!--&gt;向上移动</el-button>-->
                  <!--</div>-->

                  <!--&lt;!&ndash; <div v-if="i.direction">-->
                    <!--<el-row :gutter="20" style="margin:0">-->
                      <!--<el-col :span="8">-->
                        <!--<el-button style="margin-left:18px" type="text" disabled>规则ID:{{i.ruleId}}</el-button>-->
                      <!--</el-col>-->
                      <!--<el-col :span="12" v-if="i.ruleType=='single'"></el-col>-->
                    <!--</el-row>-->
                    <!--<el-row :gutter="20">-->
                      <!--<el-col-->
                        <!--:span="16"-->
                        <!--style=" border: 1px solid #F2F6FC;width:80%;height:200px;margin-left:18px;margin-bottom:18px"-->
                      <!--&gt;-->
                        <!--<el-row style="margin:0">-->
                          <!--<el-button-->
                            <!--style="margin-top:1%;margin-left:1%"-->
                            <!--size="mini"-->
                            <!--type="text"-->
                            <!--disabled-->
                          <!--&gt;执行日志</el-button>-->
                        <!--</el-row>-->
                        <!--<el-row :gutter="20" style="margin-left:1%">-->
                          <!--<el-col :span="12">-->
                            <!--<el-form v-if="i.ruleType=='single'" size="mini">-->
                              <!--<el-card-->
                                <!--v-if="i.method.id==1"-->
                                <!--style="margin: 1%;width:80%;height:80%;float:left;background-color:#D9ECFF"-->
                                <!--:key="i"-->
                                <!--shadow="always"-->
                                <!--class="box-card"-->
                              <!--&gt;-->
                                <!--<el-tag style="float:left" size="mini" effect="plain">学生去重</el-tag>-->
                                <!---->
                                <!--<el-divider style="width:100%"></el-divider>-->
                                <!--<el-row style="text-align:left">-->
                                  <!--<div style="font-size: 12px;">作用：统计数据源出现过的学生</div>-->
                                  <!--<div style="font-size: 12px;">举例：统计流水记录有记录的学生</div>-->
                                <!--</el-row>-->
                              <!--</el-card>-->
                              <!--<el-card-->
                                <!--style="margin: 1%;width:80%;height:80%;float:left;background-color:#D9ECFF"-->
                                <!--v-if="i.method.id==2"-->
                                <!--:key="i"-->
                                <!--shadow="always"-->
                                <!--class="box-card"-->
                              <!--&gt;-->
                                <!--<el-tag style="float:left" size="mini" effect="plain">SUM求和</el-tag>-->
                                <!---->
                                <!--<el-divider style="width:100%"></el-divider>-->
                                <!--<el-row style="text-align:left">-->
                                  <!--<div style="font-size: 12px;">作用：计算求和</div>-->
                                  <!--<div style="font-size: 12px;">举例：计算学生上网时长总和</div>-->
                                <!--</el-row>-->
                              <!--</el-card>-->
                              <!--<el-card-->
                                <!--style="margin: 1%;width:80%;height:80%;float:left;background-color:#D9ECFF"-->
                                <!--v-if="i.method.id==3"-->
                                <!--:key="i"-->
                                <!--shadow="always"-->
                                <!--class="box-card"-->
                              <!--&gt;-->
                                <!--<el-tag style="float:left" size="mini" effect="plain">count次数</el-tag>-->
                                <!---->
                                <!--<el-divider style="width:100%"></el-divider>-->
                                <!--<el-row style="text-align:left">-->
                                  <!--<div style="font-size: 12px;">作用：统计次数</div>-->
                                  <!--<div style="font-size: 12px;">举例：统计消费次数</div>-->
                                <!--</el-row>-->
                              <!--</el-card>-->
                            <!--</el-form>-->

                            <!--<el-form v-if="i.ruleType == 'double'" size="mini">-->
                              <!--<el-form-item v-for="(y) in i.pojo" :key="y" :label="y.name">-->
                                <!--<el-button-->
                                  <!--@click="currentRule=y;dialogSourceVisible = true"-->
                                  <!--type="primary"-->
                                <!--&gt;{{y.label}}</el-button>-->
                                <!--<el-select-->
                                  <!--v-if="y.origin!='double'"-->
                                  <!--size="mini"-->
                                  <!--style="width:50%"-->
                                  <!--v-model="y.field"-->
                                  <!--filterable-->
                                  <!--placeholder="选择字段"-->
                                <!--&gt;-->
                                  <!--<el-option-->
                                    <!--v-for="item in y.pojoElements"-->
                                    <!--:key="item.value"-->
                                    <!--:label="item.label"-->
                                    <!--:value="item.value"-->
                                  <!--&gt;</el-option>-->
                                <!--</el-select>-->
                              <!--</el-form-item>-->

                              <!--<el-form-item label="集合关系">-->
                                <!---->
                                <!--<el-select-->
                                  <!--size="mini"-->
                                  <!--style="width:50%"-->
                                  <!--v-model="i.logic.value"-->
                                  <!--placeholder="选择逻辑关系"-->
                                <!--&gt;-->
                                  <!--<el-option-->
                                    <!--v-for="item in setRelation"-->
                                    <!--:key="item.value"-->
                                    <!--:label="item.label"-->
                                    <!--:value="item.value"-->
                                  <!--&gt;</el-option>-->
                                <!--</el-select>-->
                                <!---->
                              <!--</el-form-item>-->
                            <!--</el-form>-->
                          <!--</el-col>-->

                          <!--<el-col-->
                            <!--:span="10"-->
                            <!--v-if="i.ruleType=='single'&& (i.method.id==2|| i.method.id==3)"-->
                          <!--&gt;-->
                            <!--<el-form size="mini">-->
                              <!--<el-form-item label="表达式 ">-->
                                <!--<el-row>-->
                                  <!--<el-select style="width:30%" v-model="i.logic" placeholder="逻辑因子">-->
                                    <!--<el-option-->
                                      <!--v-for="item in logics"-->
                                      <!--:key="item.value"-->
                                      <!--:label="item.label"-->
                                      <!--:value="item.value"-->
                                    <!--&gt;</el-option>-->
                                  <!--</el-select>-->

                                  <!--<el-input-->
                                    <!--v-model.number="i.value"-->
                                    <!--style="width:40%"-->
                                    <!--placeholder="判定值"-->
                                    <!--type="number"-->
                                  <!--&gt;</el-input>-->
                                  <!--<el-button-->
                                    <!--style="font-size: 20px;color:rgb(144, 147, 153)"-->
                                    <!--type="text"-->
                                    <!--class="el-icon-circle-check"-->
                                    <!--@click="addLogic(i)"-->
                                  <!--&gt;</el-button>-->
                                <!--</el-row>-->
                              <!--</el-form-item>-->
                              <!--<el-form-item>-->
                                <!--<el-row>-->
                                  <!--<el-input v-model="i.logicMvel" style="width:83%" disabled></el-input>-->
                                  <!--<el-button-->
                                    <!--style="font-size: 20px;color:rgb(144, 147, 153)"-->
                                    <!--type="text"-->
                                    <!--class="el-icon-delete"-->
                                    <!--@click="i.logics=[];i.logicMvel=null"-->
                                  <!--&gt;</el-button>-->
                                <!--</el-row>-->
                              <!--</el-form-item>-->
                            <!--</el-form>-->
                          <!--</el-col>-->
                        <!--</el-row>-->
                      <!--</el-col>-->
                      <!--<el-col :span="4">-->
                        <!--<div style="margin : 40%">-->
                          <!--<el-tooltip-->
                            <!--v-if="!i.ToBeSource"-->
                            <!--content="锁定规则"-->
                            <!--placement="bottom"-->
                            <!--effect="light"-->
                          <!--&gt;-->
                            <!--<el-button-->
                              <!--@click="upgrade(i,i.ruleId,i.name)"-->
                              <!--style="font-size:25px;color:#909399"-->
                              <!--icon="el-icon-unlock"-->
                              <!--circle-->
                            <!--&gt;</el-button>-->
                          <!--</el-tooltip>-->
                          <!--<el-tooltip v-else content="解锁规则" placement="bottom" effect="light">-->
                            <!--<el-button-->
                              <!--@click="upgrade(i,i.ruleId,i.name)"-->
                              <!--style="font-size:25px;color:#F56C6C"-->
                              <!--icon="el-icon-lock"-->
                              <!--circle-->
                            <!--&gt;</el-button>-->
                          <!--</el-tooltip>-->
                        <!--</div>-->
                      <!--</el-col>-->
                    <!--</el-row>-->
                  <!--</div>&ndash;&gt;-->
                <!--</div>-->
              <!--</div>-->
              <!--<div v-else style="margin-left:1%;height:80%;overflow: auto;text-align:center">-->
                <!--<el-tooltip content="还未设计规则" placement="bottom" effect="light">-->
                  <!--<el-button-->
                    <!--class="el-icon-setting"-->
                    <!--type="text"-->
                    <!--style="font-size:100px;color:#C0C4CC;margin-top:20%"-->
                  <!--&gt;</el-button>-->
                <!--</el-tooltip>-->
              <!--</div>-->
              <!--<div style="height:10%;width:100%">-->
                <!--<el-row>-->
                  <!--<el-button-->
                    <!--style="float:right;margin-right:2%;margin-top:2%"-->
                    <!--type="warning"-->
                    <!--size="small"-->
                    <!--@click="saveRule"-->
                  <!--&gt;保存</el-button>-->

                  <!--<el-button-->
                    <!--style="float:right;margin-right:2%;margin-top:2%"-->
                    <!--type="success"-->
                    <!--size="small"-->
                    <!--@click="testCheck"-->
                  <!--&gt;测试</el-button>-->
                <!--</el-row>-->
              <!--</div>-->
            <!--</div>-->
          <!--</el-col>-->
        <!--</el-row>-->
      <!--</el-tab-pane>-->
    <!--</el-tabs>-->

    <!--&lt;!&ndash; 数据来源DIALOG &ndash;&gt;-->
    <!--<el-dialog width="30%" title="数据源设置" :visible.sync="dialogSourceVisible">-->
      <!--<el-form>-->
        <!--<el-form-item label="数据来源" label-width="120px">-->
          <!--<el-select v-model="currentSource" style="width:100%" placeholder="选择数据来源">-->
            <!--<el-option-->
              <!--v-for="item in datasources"-->
              <!--:key="item.value"-->
              <!--:label="item.label"-->
              <!--:value="item"-->
            <!--&gt;</el-option>-->
          <!--</el-select>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<div slot="footer" class="dialog-footer">-->
        <!--<el-button @click="dialogSourceVisible = false">取 消</el-button>-->
        <!--<el-button type="primary" @click="confirmSource() ;dialogSourceVisible = false">确 定</el-button>-->
      <!--</div>-->
    <!--</el-dialog>-->

    <!--<el-dialog width="30%" title="新增规则组" :visible.sync="addNode">-->
      <!--<el-form label-width="160px" size="mini">-->
        <!--<el-form-item label="名称">-->
          <!--<el-input v-model="currentCategory"></el-input>-->
        <!--</el-form-item>-->

        <!--<el-form-item label="初始学生群体样本">-->
          <!--<el-input v-model="countSample" disabled></el-input>-->
        <!--</el-form-item>-->

        <!--<el-form-item label="规则组执行逻辑">-->
          <!--<el-checkbox v-model="checkedModel" disabled>顺序衰减样本</el-checkbox>-->
        <!--</el-form-item>-->
      <!--</el-form>-->
      <!--<div slot="footer" class="dialog-footer">-->
        <!--<el-button @click="addNode = false">取 消</el-button>-->
        <!--<el-button type="primary" @click="addRuleGroup() ">确 定</el-button>-->
      <!--</div>-->
    <!--</el-dialog>-->
  <!--</div>-->
<!--</template>-->

<!--<script>-->
<!--// import { getColumns, readPojoById, getCategoryList } from "@/api/pojoset";-->
<!--// import {-->
<!--//   save,-->
<!--//   getRuleByCategory,-->
<!--//   getCategory,-->
<!--//   fire,-->
<!--//   getFields,-->
<!--//   getDataObjectByName,-->
<!--//   countSample,-->
<!--//   delRuleById-->
<!--// } from "@/api/ndwc";-->
<!--// import draggable from "vuedraggable";-->
<!--// import { delimiter } from "path";-->
<!--export default {-->
  <!--watch: {},-->
  <!--data() {-->
    <!--return {-->
      <!--countSample: null,-->
      <!--groupRule: {-->
        <!--dampingPojo: {-->
          <!--datasource: {},-->
          <!--dataJson: [],-->
          <!--dataSql: null,-->
          <!--dataName: null-->
        <!--},-->
        <!--ruleArray: []-->
      <!--},-->
      <!--groupSource: null,-->
      <!--checkedModel: true,-->
      <!--ruleMvel: [],-->
      <!--loading: false,-->
      <!--currentCategory: null,-->
      <!--addNode: false,-->
      <!--methods: [-->
        <!--{-->
          <!--id: 1,-->
          <!--name: "distinct",-->
          <!--mvel:-->
            <!--"matchProvider.distinctFunc(DataSupport.getOriginData,DataSupport.getRuleDataMap,"-->
        <!--},-->
        <!--{-->
          <!--id: 2,-->
          <!--name: "sum",-->
          <!--mvel:-->
            <!--"matchProvider.sumFunc(DataSupport.getOriginData,DataSupport.getRuleDataMap,"-->
        <!--},-->
        <!--{-->
          <!--id: 3,-->
          <!--name: "count",-->
          <!--mvel:-->
            <!--"matchProvider.countFunc(DataSupport.getOriginData,DataSupport.getRuleDataMap,"-->
        <!--},-->
        <!--{-->
          <!--id: 4,-->
          <!--name: "unionSet",-->
          <!--mvel: "matchProvider.unionSet("-->
        <!--},-->
        <!--{-->
          <!--id: 5,-->
          <!--name: "intersection(",-->
          <!--mvel: "matchProvider.intersection("-->
        <!--},-->
        <!--{-->
          <!--id: 6,-->
          <!--name: "differenceSet",-->
          <!--mvel: "matchProvider.differenceSet("-->
        <!--}-->
      <!--],-->

      <!--radio4: null,-->
      <!--color1: "background-color:#D9ECFF",-->
      <!--color2: "background-color:#F4F4F5",-->
      <!--checked: false,-->
      <!--flag: "hover",-->
      <!--mathElements: [],-->
      <!--datasources: [],-->
      <!--currentSource: null,-->
      <!--currentRule: {},-->
      <!--setRelation: [-->
        <!--{-->
          <!--label: "交集",-->
          <!--value: "matchProvider.intersection(",-->
          <!--desc: "集合一集合二都存在的数据"-->
        <!--},-->
        <!--{-->
          <!--label: "并集",-->
          <!--value: "matchProvider.unionSet(",-->
          <!--desc: "在两个或任何一个集里的数据"-->
        <!--},-->
        <!--{-->
          <!--label: "差集",-->
          <!--desc: "在集合一里但不在集合二里",-->
          <!--value: "matchProvider.differenceSet("-->
        <!--}-->
      <!--],-->
      <!--fieldTypes: [-->
        <!--{-->
          <!--value: "number",-->
          <!--label: "数值"-->
        <!--},-->
        <!--{-->
          <!--value: "String",-->
          <!--label: "字符串"-->
        <!--},-->
        <!--{-->
          <!--value: "Date",-->
          <!--label: "日期"-->
        <!--}-->
      <!--],-->
      <!--logics: [-->
        <!--{-->
          <!--label: "<",-->
          <!--value: "<"-->
        <!--},-->
        <!--{-->
          <!--label: "<=",-->
          <!--value: "<="-->
        <!--},-->
        <!--{-->
          <!--label: ">",-->
          <!--value: ">"-->
        <!--},-->
        <!--{-->
          <!--label: ">=",-->
          <!--value: ">="-->
        <!--},-->
        <!--{-->
          <!--label: "=",-->
          <!--value: "="-->
        <!--},-->
        <!--{-->
          <!--label: "!=",-->
          <!--value: "!="-->
        <!--}-->
      <!--],-->
      <!--dialogSourceVisible: false,-->
      <!--direction: true,-->
      <!--treeDoms: [],-->
      <!--ruleSet: []-->
    <!--};-->
  <!--},-->
  <!--components: {-->
    <!--draggable-->
  <!--},-->
  <!--methods: {-->
    <!--verifyDel(node, data) {-->
      <!--this.$confirm("即将删除本条规则组, 是否继续?", "提示", {-->
        <!--confirmButtonText: "确定",-->
        <!--cancelButtonText: "取消",-->
        <!--type: "warning"-->
      <!--})-->
        <!--.then(() => {-->
          <!--this.$message({-->
            <!--type: "success",-->
            <!--message: "删除成功!"-->
          <!--});-->
          <!--delRuleById(data.id).then(() => {-->
            <!--this.ruleSet.length = 0;-->
            <!--this.getCategory();-->
          <!--});-->
        <!--})-->
        <!--.catch(() => {-->
          <!--this.$message({-->
            <!--type: "info",-->
            <!--message: "已取消删除"-->
          <!--});-->
        <!--});-->
    <!--},-->

    <!--addRuleGroup() {-->
      <!--let a = [];-->
      <!--this.treeDoms.forEach(element => {-->
        <!--a.push(element.label);-->
      <!--});-->
      <!--if (a.indexOf(this.currentCategory) >= 0) {-->
        <!--this.$message({-->
          <!--type: "warning",-->
          <!--message: "该目录已经存在"-->
        <!--});-->
      <!--} else {-->
        <!--// this.treeDoms.push({ id: 0, label: this.currentCategory });-->
        <!--this.append("damping");-->
        <!--this.addNode = false;-->
      <!--}-->
    <!--},-->

    <!--addLogic(i) {-->
      <!--let a = {};-->
      <!--a[i.logic] = i.value;-->
      <!--i.logics.push(a);-->
      <!--i.logicMvel = JSON.stringify(i.logics);-->
    <!--},-->

    <!--handleNodeClick(data, node) {-->
      <!--// if(data.id!=0){-->
      <!--//   this.groupRuleConfirm()-->
      <!--// }-->
      <!--this.currentCategory = data.label;-->
      <!--this.getRuleByCategory(data.label);-->
    <!--},-->

    <!--// groupRuleConfirm() {-->
    <!--//   this.treeDoms.forEach(el => {-->
    <!--//     if (el.id == 0) {-->
    <!--//       this.$confirm("有还未保存的规则组, 是否保存?", "提示", {-->
    <!--//         confirmButtonText: "保存",-->
    <!--//         cancelButtonText: "不保存",-->
    <!--//         type: "warning"-->
    <!--//       })-->
    <!--//         .then(() => {-->
    <!--//           this.$message({-->
    <!--//             type: "success",-->
    <!--//             message: "保存成功!"-->
    <!--//           });-->
    <!--//           this.saveRule();-->
    <!--//         })-->
    <!--//         .catch(() => {-->
    <!--//           this.$message({-->
    <!--//             type: "info",-->
    <!--//             message: "已取消保存"-->
    <!--//           });-->
    <!--//         });-->
    <!--//     }-->
    <!--//   });-->
    <!--// },-->

    <!--saveRule() {-->
      <!--let a = {};-->
      <!--a.ruleSet = this.ruleSet;-->
      <!--a.groupRule = this.groupRule;-->
      <!--this.packageParams();-->
      <!--save({-->
        <!--userId: "1",-->
        <!--category: this.currentCategory,-->
        <!--data: JSON.stringify(this.ruleSet),-->
        <!--mvel: JSON.stringify(this.groupRule)-->
      <!--}).then(response => {-->
        <!--this.open("保存成功", "success");-->
        <!--this.getCategory();-->
      <!--});-->
    <!--},-->

    <!--packageParams() {-->
      <!--let params = [];-->
      <!--this.ruleSet.forEach((e, $index) => {-->
        <!--let id = $index + 1;-->
        <!--let param = {};-->
        <!--let mvel = null;-->
        <!--if (e.ruleType == "single") {-->
          <!--param.pojo = {-->
            <!--datasource: e.pojo.datasource,-->
            <!--dataJson: e.pojo.pojoElements,-->
            <!--dataSql: e.pojo.dataSql,-->
            <!--dataName: e.pojo.tableName-->
          <!--};-->
          <!--mvel =-->
            <!--"matchProvider.listRomve(DataSupport.getOriginData,DataSupport.getSample);matchProvider.distinctFunc(DataSupport.getOriginData,DataSupport.getRuleDataMap," +-->
            <!--id +-->
            <!--",DataSupport.getTimeSpan());matchProvider.addSet(DataSupport.getRuleDataMap.get(" +-->
            <!--id +-->
            <!--"),DataSupport.getSample)";-->
          <!--param.rule = { MVELExpression: [] };-->
          <!--param.rule.MVELExpression.push({-->
            <!--name: "规则",-->
            <!--description: "description",-->
            <!--priority: 1,-->
            <!--condition: "1==1",-->
            <!--action: mvel-->
          <!--});-->
          <!--params.push(param);-->
        <!--} else {-->
          <!--let dMvel = "";-->
          <!--let ruleId = e.ruleId + 1;-->
          <!--e.pojo.forEach(ele => {-->
            <!--if (ele.origin == "rule" || ele.origin == "double") {-->
              <!--let id = ele.value + 1;-->
              <!--dMvel = dMvel + "DataSupport.getRuleDataMap.get(" + id + "),";-->
            <!--}-->
          <!--});-->
          <!--dMvel =-->
            <!--e.logic.value + dMvel + ruleId + ",DataSupport.getRuleDataMap)";-->
          <!--let a = {};-->
          <!--a.rule = { MVELExpression: [] };-->
          <!--a.rule.MVELExpression.push({-->
            <!--name: "规则",-->
            <!--description: "description",-->
            <!--priority: 1,-->
            <!--condition: "1==1",-->
            <!--action: dMvel-->
          <!--});-->
          <!--params.push(a);-->
        <!--}-->
      <!--});-->
      <!--params;-->
      <!--this.groupRule.ruleArray = params;-->
    <!--},-->

    <!--testCheck() {-->
      <!--this.groupRule;-->
      <!--this.packageParams();-->
      <!--this.loading = true;-->
      <!--fire({ array: this.groupRule }).then(response => {-->
        <!--this.loading = false;-->
        <!--let message = null;-->
        <!--message = response.data.resultSet.length;-->
        <!--response.data.elapsedTime.forEach((element, index) => {-->
          <!--this.ruleSet[index].elapsedTime = element;-->
        <!--});-->
        <!--let time = null;-->
        <!--time = response.data.time;-->
        <!--if (message) {-->
          <!--this.$notify({-->
            <!--title: "执行结果",-->
            <!--message: "一共有" + message + "条学生记录",-->
            <!--duration: 0,-->
            <!--type: "success"-->
          <!--});-->
        <!--} else {-->
          <!--this.$notify.error({-->
            <!--title: "错误",-->
            <!--message: "执行失败"-->
          <!--});-->
        <!--}-->
      <!--});-->
    <!--},-->

    <!--getRuleByCategory(category) {-->
      <!--getRuleByCategory(category).then(response => {-->
        <!--if (!response.data) {-->
        <!--} else {-->
          <!--this.ruleSet = JSON.parse(response.data.data);-->
        <!--}-->
      <!--});-->
    <!--},-->

    <!--append(type) {-->
      <!--if (type == "damping") {-->
        <!--this.ruleSet.length = 0;-->
        <!--for (let i = 0; i < 5; i++) {-->
          <!--this.ruleSet.push({-->
            <!--name: null,-->
            <!--elapsedTime: null,-->
            <!--desc: null,-->
            <!--pojo: {-->
              <!--label: "选择数据来源",-->
              <!--value: "",-->
              <!--field: {-->
                <!--label: "",-->
                <!--value: ""-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--direction: false,-->
            <!--ruleColor: "background-color:#F2F6FC;",-->
            <!--ruleType: "single",-->
            <!--ruleId: i + 1,-->
            <!--fieldType: "",-->
            <!--logic: "",-->
            <!--value: "",-->
            <!--logics: [],-->
            <!--logicMvel: "",-->
            <!--mulSelect: false,-->
            <!--callbackFields: [],-->
            <!--ToBeSource: false,-->
            <!--method: {-->
              <!--id: null,-->
              <!--mvel: null-->
            <!--}-->
          <!--});-->
        <!--}-->
      <!--} else {-->
        <!--this.ruleSet.length = 0;-->
        <!--this.ruleSet.push({-->
          <!--name: null,-->
          <!--desc: "",-->
          <!--pojo: {-->
            <!--label: "选择数据来源",-->
            <!--value: "",-->
            <!--field: {-->
              <!--label: "",-->
              <!--value: ""-->
            <!--},-->
            <!--pojoElements: []-->
          <!--},-->
          <!--direction: true,-->
          <!--ruleColor: "background-color:#F2F6FC;",-->
          <!--ruleType: "single",-->
          <!--ruleId: 0,-->
          <!--fieldType: "",-->
          <!--logic: "",-->
          <!--value: "",-->
          <!--logics: [],-->
          <!--logicMvel: "",-->
          <!--mulSelect: false,-->
          <!--callbackFields: [],-->
          <!--ToBeSource: false,-->
          <!--method: {-->
            <!--id: null,-->
            <!--mvel: null-->
          <!--}-->
        <!--});-->
      <!--}-->
    <!--},-->

    <!--open(message, type) {-->
      <!--this.$message({-->
        <!--message: message,-->
        <!--type: type-->
      <!--});-->
    <!--},-->

    <!--addRule(array) {-->
      <!--let index = array[1] + 1;-->
      <!--let id = array[1] + 2;-->
      <!--if (array[0] == "s") {-->
        <!--let a = {-->
          <!--name: null,-->
          <!--elapsedTime: null,-->
          <!--desc: null,-->
          <!--pojo: {-->
            <!--label: "选择数据来源",-->
            <!--value: "",-->
            <!--field: {-->
              <!--label: "",-->
              <!--value: ""-->
            <!--},-->
            <!--pojoElements: []-->
          <!--},-->
          <!--direction: true,-->
          <!--ruleColor: "background-color:#F2F6FC;",-->
          <!--ruleType: "single",-->
          <!--ruleId: id,-->
          <!--fieldType: "",-->
          <!--logic: "",-->
          <!--value: "",-->
          <!--logics: [],-->
          <!--logicMvel: "",-->
          <!--mulSelect: false,-->
          <!--callbackFields: [],-->
          <!--ToBeSource: false,-->
          <!--method: {-->
            <!--id: null,-->
            <!--mvel: null-->
          <!--}-->
        <!--};-->
        <!--this.ruleSet.splice(index, 0, a);-->
      <!--} else {-->
        <!--let a = {-->
          <!--name: null,-->
          <!--desc: "",-->
          <!--pojo: [-->
            <!--{-->
              <!--name: "集合一",-->
              <!--label: "选择数据来源",-->
              <!--value: "",-->
              <!--field: {-->
                <!--label: "",-->
                <!--value: ""-->
              <!--},-->
              <!--pojoElements: []-->
            <!--},-->
            <!--{-->
              <!--name: "集合二",-->
              <!--label: "选择数据来源",-->
              <!--value: "",-->
              <!--field: {-->
                <!--label: "",-->
                <!--value: ""-->
              <!--},-->
              <!--pojoElements: []-->
            <!--}-->
          <!--],-->
          <!--direction: true,-->
          <!--ruleColor: "background-color:#FAECD8",-->
          <!--ruleType: "double",-->
          <!--ruleId: id,-->
          <!--ToBeSource: false,-->
          <!--callbackFields: [],-->
          <!--logic: {-->
            <!--label: null,-->
            <!--value: null,-->
            <!--desc: "还未选择"-->
          <!--},-->
          <!--method: {-->
            <!--id: null,-->
            <!--mvel: null-->
          <!--}-->
        <!--};-->
        <!--this.ruleSet.splice(index, 0, a);-->
      <!--}-->
      <!--this.ruleSet.forEach((element, i) => {-->
        <!--if (i != array[1] + 1) {-->
          <!--element.direction = false;-->
        <!--}-->
      <!--});-->
    <!--},-->
    <!--// upgrad rule result to datasource-->
    <!--upgrade(i, id, name) {-->
      <!--if (i.ToBeSource) {-->
        <!--i.ToBeSource = false;-->
        <!--this.datasources.forEach((el, index) => {-->
          <!--if (el.value == id && (el.flag == "rule" || el.flag == "double")) {-->
            <!--this.datasources.splice(index, 1);-->
          <!--}-->
        <!--});-->
      <!--} else {-->
        <!--i.ToBeSource = true;-->
        <!--let a = [];-->
        <!--this.datasources.forEach(element => {-->
          <!--if (element.flag == "rule") {-->
            <!--a.push(element.value);-->
          <!--}-->
        <!--});-->
        <!--if (a.indexOf(id) < 0) {-->
          <!--if (i.ruleType == "double") {-->
            <!--this.datasources.push({ label: name, value: id, flag: "double" });-->
          <!--} else {-->
            <!--this.datasources.push({ label: name, value: id, flag: "rule" });-->
          <!--}-->
        <!--}-->
      <!--}-->
    <!--},-->

    <!--// 向上移动-->
    <!--uppWard(index) {-->
      <!--if (this.ruleSet[index - 1].ToBeSource) {-->
        <!--this.$message.error("上层有升级为数据源的规则无法移动");-->
      <!--} else {-->
        <!--[this.ruleSet[index - 1], this.ruleSet[index]] = [-->
          <!--this.ruleSet[index],-->
          <!--this.ruleSet[index - 1]-->
        <!--];-->
        <!--this.ruleSet.forEach((el, index) => {-->
          <!--el.ruleId = index + 1;-->
        <!--});-->
        <!--this.$set(this.ruleSet, 0, this.ruleSet[0]);-->
      <!--}-->
    <!--},-->
    <!--// 删除-->
    <!--deleteRule(index) {-->
      <!--if (index !== 0) {-->
        <!--this.ruleSet.splice(index, 1);-->
      <!--} else {-->
        <!--this.open("警告，规则数量至少为1", "warning");-->
      <!--}-->
    <!--},-->
    <!--showDom(index) {-->
      <!--this.ruleSet[index].direction = this.ruleSet[index].direction-->
        <!--? false-->
        <!--: true;-->
      <!--if (!this.ruleSet[index].direction) {-->
      <!--}-->
    <!--},-->
    <!--packUpAll() {-->
      <!--this.ruleSet.forEach(element => {-->
        <!--if (element.direction) {-->
          <!--element.direction = false;-->
        <!--}-->
      <!--});-->
    <!--},-->
    <!--unfold() {-->
      <!--this.ruleSet.forEach(element => {-->
        <!--if (!element.direction) {-->
          <!--element.direction = true;-->
        <!--}-->
      <!--});-->
    <!--},-->

    <!--confirmSource() {-->
      <!--switch (this.currentSource.flag) {-->
        <!--case "rule":-->
          <!--this.currentRule.label = this.currentSource.label;-->
          <!--this.currentRule.value = this.currentSource.value;-->
          <!--this.currentRule.origin = this.currentSource.flag;-->
          <!--break;-->
        <!--case "double":-->
          <!--this.currentRule.label = this.currentSource.label;-->
          <!--this.currentRule.value = this.currentSource.value;-->
          <!--this.currentRule.origin = this.currentSource.flag;-->
          <!--break;-->
        <!--case "pojo":-->
          <!--this.currentRule.label = this.currentSource.label;-->
          <!--this.currentRule.value = this.currentSource.value;-->
          <!--this.readPojoPromise(this.currentRule.value).then(value => {-->
            <!--this.currentRule.pojoElements.length = 0;-->
            <!--let config = value.dataJson;-->
            <!--config.forEach(element => {-->
              <!--this.currentRule.pojoElements.push(element);-->
              <!--this.currentRule.datasource = value.datasource;-->
              <!--this.currentRule.dataSql = value.dataSql;-->
              <!--this.currentRule.tableName = value.tableName;-->
            <!--});-->
          <!--});-->
          <!--this.currentRule.pojoElements;-->

          <!--break;-->
      <!--}-->
    <!--},-->

    <!--readPojoPromise(id) {-->
      <!--let promise = new Promise((resolve, reject) => {-->
        <!--getDataObjectByName(id)-->
          <!--.then(response => {-->
            <!--resolve(response.data);-->
          <!--})-->
          <!--.catch(error => {-->
            <!--reject(error);-->
          <!--});-->
      <!--});-->
      <!--return promise;-->
    <!--},-->

    <!--getPojoListInit() {-->
      <!--getCategoryList("1").then(response => {-->
        <!--response.data.forEach(element => {-->
          <!--if (element.id !== 0) {-->
            <!--let a = { label: element.name, value: element.id, flag: "pojo" };-->
            <!--this.datasources.push(a);-->
          <!--}-->
        <!--});-->
      <!--});-->
    <!--},-->
    <!--getCategory() {-->
      <!--getCategory().then(response => {-->
        <!--this.treeDoms.length = 0;-->
        <!--response.data.forEach(element => {-->
          <!--this.treeDoms.push({ id: element.id, label: element.category });-->
        <!--});-->
      <!--});-->
    <!--},-->
    <!--getSourcesInit() {-->
      <!--getFields().then(response => {-->
        <!--response.data.forEach(element => {-->
          <!--let a = {-->
            <!--label: element.name,-->
            <!--value: element.tableName,-->
            <!--flag: "pojo"-->
          <!--};-->
          <!--this.datasources.push(a);-->
        <!--});-->
      <!--});-->
    <!--},-->
    <!--countSampleInit() {-->
      <!--countSample().then(response => {-->
        <!--this.countSample = response.data + "人";-->
      <!--});-->
    <!--},-->
    <!--groupRuleInit() {-->
      <!--getDataObjectByName("t_tab_student").then(response => {-->
        <!--this.groupRule.dampingPojo.datasource = response.data.datasource;-->
        <!--this.groupRule.dampingPojo.dataJson = response.data.dataJson;-->
        <!--this.groupRule.dampingPojo.dataSql = response.data.dataSql;-->
        <!--let a = {};-->
        <!--this.groupRule.dampingPojo.rule = {};-->
        <!--this.groupRule.dampingPojo.rule.MVELExpression = [];-->
        <!--(a.name = "rule1"), (a.condition = "1==1");-->
        <!--a.action =-->
          <!--"DataSupport.setCompareData(matchProvider.getDataByFields(DataSupport.getOriginData,'getSTUDENTID'));";-->
        <!--a.description = "description";-->
        <!--a.priority = 1;-->
        <!--this.groupRule.dampingPojo.rule.MVELExpression.push(a);-->
        <!--this.groupRule.dampingPojo.rule = JSON.stringify(-->
          <!--this.groupRule.dampingPojo.rule-->
        <!--);-->
      <!--});-->
      <!--this.groupRule.finalRule = {};-->
      <!--this.groupRule.finalRule.MVELExpression = [];-->
      <!--let b = {};-->
      <!--b.name = "rule1";-->
      <!--b.condition = "1==1";-->
      <!--b.action =-->
        <!--"matchProvider.differenceSet(DataSupport.getCompareData(),DataSupport.getSample(),100,DataSupport.getRuleDataMap);";-->
      <!--b.description = "description";-->
      <!--b.priority = 1;-->
      <!--this.groupRule.finalRule.MVELExpression.push(b);-->
      <!--this.groupRule.finalRule = JSON.stringify(this.groupRule.finalRule);-->
    <!--}-->
  <!--},-->

  <!--mounted: function() {-->
    <!--// this.getPojoListInit();-->
    <!--this.groupRuleInit();-->
    <!--this.countSampleInit();-->
    <!--this.getSourcesInit();-->
    <!--this.getCategory();-->
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

<!--.cutline::-webkit-scrollbar {-->
  <!--width: 0 !important;-->
<!--}-->
<!--</style>-->
